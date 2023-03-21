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

}




