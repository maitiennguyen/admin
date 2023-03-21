import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Save extends ReportDAO implements sqlDataMethods
{
    @Override
    public void saveReportShortAnswers(Report report)
    {
        // change date string type to object type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.parse(report.getDate(), formatter);
        Date date = Date.valueOf(localDate);
        try {
            String sql = "INSERT INTO ShortAnswers (Grad, MHI, Date, IdentityYN, ID) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, report.getGradYear());
            statement.setString(2, report.getMHI());
            statement.setDate(3, date);
            statement.setString(4, report.getIdentityYN());
            statement.setString(5, report.getId());

            statement.executeUpdate();
            System.out.println("Report submitted and saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public void saveReportLongAnswers(Report report) {
        try {
            String sql = "INSERT INTO LongAnswers (MHIT, IdentityTxt, Location, EventD, ID) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, report.getMHIText());
            statement.setString(2, report.getIdentityText());
            statement.setString(3, report.getLocation());
            statement.setString(4, report.getEventDes());
            statement.setString(5, report.getId());
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
            String sql = "SELECT * FROM ShortAnswers INNER JOIN LongAnswers ON ShortAnswers.ID = LongAnswers.ID WHERE ShortAnswers.ID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, Id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Report report = new Report();
                report.setGradYear(resultSet.getString("Grad"));
                report.setMHI(resultSet.getString("MHI"));
                report.setDate(dateFormat.format(resultSet.getDate("Date")));
                report.setIdentityYN(resultSet.getString("IdentityYN"));
                report.setMHIText(resultSet.getString("MHIT"));
                report.setIdentityText(resultSet.getString("IdentityTxt"));
                report.setLocation(resultSet.getString("Location"));
                report.setEventDes(resultSet.getString("EventD"));
                report.setId(resultSet.getString("ID"));
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
            String sql1 = "UPDATE ShortAnswers SET Grad = ?, MHI = ?, Date = ?, IdentityYN = ? WHERE ID = ?";
            PreparedStatement updateTable1Statement = conn.prepareStatement(sql1);
            updateTable1Statement.setString(1, report.getGradYear());
            updateTable1Statement.setString(2, report.getMHI());
            updateTable1Statement.setDate(3, date);
            updateTable1Statement.setString(4, report.getIdentityYN());
            updateTable1Statement.setString(5, report.getId());

            String sql2 = "UPDATE LongAnswers SET MHIT = ?, IdentityTxt = ?, Location = ?, EventD = ? WHERE ID = ?";
            PreparedStatement updateTable2Statement = conn.prepareStatement(sql2);
            updateTable2Statement.setString(1, report.getMHIText());
            updateTable2Statement.setString(2, report.getIdentityText());
            updateTable2Statement.setString(3, report.getLocation());
            updateTable2Statement.setString(4, report.getEventDes());
            updateTable2Statement.setString(5, report.getId());

            updateTable1Statement.executeUpdate();
            updateTable2Statement.executeUpdate();

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




