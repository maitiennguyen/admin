import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Save extends ReportDAO implements sqlDataMethods
{
    @Override
    public void saveReport(Report report)
    {
        // change date string type to object type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.parse(report.getDate(), formatter);
        Date date = Date.valueOf(localDate);
        try {
            String sql = "INSERT INTO Reports (Grad, MHI, MHIT, Date, IdentityYN, IdentityTxt, Location, EventD, AltID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, report.getGradYear());
            statement.setString(2, report.getMHI());
            statement.setString(3, report.getMHIText());
            statement.setDate(4, date);
            statement.setString(5, report.getIdentityYN());
            statement.setString(6, report.getIdentityText());
            statement.setString(7, report.getLocation());
            statement.setString(8, report.getEventDes());
            statement.setString(9, report.getId());
            Integer reportClass = calculateSaveClass(report.getGradYear(), report.getDate());
            if (reportClass != null)
            {
                statement.setInt(10, reportClass);
            } else {
                statement.setNull(10, java.sql.Types.INTEGER);
            }

            // create trigger
            createParseIdentityTrigger(conn);

            statement.executeUpdate();
            System.out.println("Report submitted and saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }


    public Report retrieveReport(String Id)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //set the date format
        try
        {
            String sql = "SELECT * FROM Reports WHERE AltID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, Id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Report report = new Report();
                report.setGradYear(resultSet.getString("Grad"));
                report.setMHI(resultSet.getString("MHI"));
                report.setMHIText(resultSet.getString("MHIT"));
                report.setDate(dateFormat.format(resultSet.getDate("Date")));
                report.setIdentityYN(resultSet.getString("IdentityYN"));
                report.setIdentityText(resultSet.getString("IdentityTxt"));
                report.setLocation(resultSet.getString("Location"));
                report.setEventDes(resultSet.getString("EventD"));
                report.setId(resultSet.getString("AltID"));
                System.out.println("Report retrieved successfully.");
                return report;
            }
            else
            {
                System.out.println("No report found with ID " + Id);
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving report: " + e.getMessage());
        }
        return null;
    }

    public void updateReport(Report report) {
        // change date string type to object type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.parse(report.getDate(), formatter);
        Date date = Date.valueOf(localDate);
        try {
            String sql = "UPDATE Reports SET Grad = ?, MHI = ?, MHIT = ?, Date = ?, IdentityYN = ?, IdentityTxt = ?, Location = ?, EventD = ? WHERE ID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, report.getGradYear());
            statement.setString(2, report.getMHI());
            statement.setString(3, report.getMHIText());
            statement.setDate(4, date);
            statement.setString(5, report.getIdentityYN());
            statement.setString(6, report.getIdentityText());
            statement.setString(7, report.getLocation());
            statement.setString(8, report.getEventDes());
            statement.setString(9, report.getId());
            Integer reportClass = calculateSaveClass(report.getGradYear(), report.getDate());
            if (reportClass != null)
            {
                statement.setInt(10, reportClass);
            } else {
                statement.setNull(10, java.sql.Types.INTEGER);
            }
            // create trigger
            createParseIdentityTrigger(conn);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating report: " + e.getMessage());
        }

    }

    @Override
    public void deleteReport(String Id) {
        String sql = "DELETE FROM Reports WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Id);
            pstmt.executeUpdate();
            System.out.println("Report deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting report: " + e.getMessage());
        }
    }

    public Integer calculateSaveClass(String gradYear, String dateStr)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        int yearDifference = date.getYear() - Integer.parseInt(gradYear);
        if (yearDifference >= 0 && yearDifference <= 3)
        {
            return yearDifference;
        } else {
            return null;
        }
    }
    public static void createParseIdentityTrigger(Connection conn) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TRIGGER parse_identity AFTER INSERT ON Reports\n"
                + "FOR EACH ROW\n"
                + "BEGIN\n"
                + "    DECLARE cur_id INT DEFAULT 0;\n"
                + "    DECLARE cur_class VARCHAR(255);\n"
                + "    DECLARE cur_mhi VARCHAR(255);\n"
                + "    DECLARE cur_date DATE;\n"
                + "    DECLARE cur_identity_yn VARCHAR(255);\n"
                + "    DECLARE cur_location VARCHAR(255);\n"
                + "    DECLARE cur_word VARCHAR(255);\n\n"
                + "    SET cur_id = NEW.ID;\n"
                + "    SET cur_class = NEW.Class;\n"
                + "    SET cur_mhi = NEW.MHI;\n"
                + "    SET cur_date = NEW.Date;\n"
                + "    SET cur_identity_yn = NEW.IdentityYN;\n"
                + "    SET cur_location = NEW.Location;\n\n"
                + "    -- Split the IdentityTxt column into words\n"
                + "    DECLARE cur_txt_cursor CURSOR FOR SELECT DISTINCT REGEXP_REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(IdentityTxt, ' ', numbers.n), ' ', -1), '[[:punct:]]', '') as word\n"
                + "                                        FROM\n"
                + "                                        (SELECT @row := @row + 1 AS n\n"
                + "                                        FROM (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) t1\n"
                + "                                        CROSS JOIN (SELECT 0 UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) t2\n"
                + "                                        CROSS JOIN (SELECT @row := -1) r) numbers\n"
                + "                                        JOIN Reports\n"
                + "                                        WHERE LENGTH(IdentityTxt) - LENGTH(REPLACE(IdentityTxt, ' ', '')) + 1 >= numbers.n\n"
                + "                                        AND Reports.ID = cur_id;\n"
                + "    OPEN cur_txt_cursor;\n"
                + "    FETCH cur_txt_cursor INTO cur_word;\n"
                + "    WHILE @@FETCH_STATUS = 0 DO\n"
                + "        -- Check if the column already exists in table2\n"
                + "        SET @sql = CONCAT(\"SELECT COUNT(*) INTO @cnt FROM information_schema.columns WHERE table_name = 'table2' AND column_name = '\", cur_word, \"';\");\n"
                + "        PREPARE stmt FROM @sql;\n"
                + "        EXECUTE stmt;\n"
                + "        DEALLOCATE PREPARE stmt;\n"

                + "        -- if the column exists, update the corresponding row, otherwise add a new column to the table\n"
                + "        IF @cnt = 1 THEN\n"
                + "              SET @sql = CONCAT(\"UPDATE table2 SET `\", cur_word, \"` = 1 WHERE ID = \", cur_id, \";\");\n"
                + "        ELSE\n"
                + "              SET @sql = CONCAT(\"ALTER TABLE table2 ADD COLUMN `\", cur_word, \"` INT DEFAULT NULL;\");\n"
                + "              PREPARE stmt FROM @sql;\n"
                + "              EXECUTE stmt;\n"
                + "              DEALLOCATE PREPARE stmt;\n"
                + "              SET @sql = CONCAT(\"INSERT INTO table2 (ID, Class, MHI, Date, IdentityYN, Location, `\", cur_word, \"`) VALUES (\", cur_id, \", '\", cur_class, \"', '\", cur_mhi, \"', '\", cur_date, \"', '\", cur_identity_yn, \"', '\", cur_location, \"', 1);\");\n"
                + "        END IF;\n"

                + "              PREPARE stmt FROM @sql;\n"
                + "        PREPARE stmt FROM @sql;\n"
                + "        EXECUTE stmt;\n"
                + "        DEALLOCATE PREPARE stmt;\n"
                + "        FETCH cur_txt_cursor INTO cur_word;\n"
                + "    END WHILE"
                + "    CLOSE cur_txt_cursor;\n"
                + "END;");
    }
}




