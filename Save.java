import java.sql.*;

public class Save extends ReportDAO implements sqlDataMethods {
    @Override
    public void saveReport(Report report) {
        try {
            String sql = "INSERT INTO Reports (Grad, MHI, MHIT, Date, IdentityYN, IdentityTxt, Location, EventD) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, report.getGradYear());
            statement.setString(2, report.getMHI());
            statement.setString(3, report.getMHIText());
            statement.setString(4, report.getDate());
            statement.setString(5, report.getIdentityYN());
            statement.setString(6, report.getIdentityText());
            ReportDAO.statement.setString(7, report.getLocation());
            statement.setString(8, report.getEventDes());
            statement.setString(9, report.getId());
            statement.executeUpdate();
            System.out.println("Report submitted and saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public void retrieveReport(String Id) {
        try {
            String sql = "SELECT * FROM Reports WHERE ReportID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, Id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Report report = new Report();
                report.setGradYear(resultSet.getString("Grad"));
                report.setMHI(resultSet.getString("MHI"));
                report.setMHIText(resultSet.getString("MHIT"));
                report.setDate(resultSet.getString("Date"));
                report.setIdentityYN(resultSet.getString("IdentityYN"));
                report.setIdentityText(resultSet.getString("IdentityTxt"));
                report.setLocation(resultSet.getString("Location"));
                report.setEventDes(resultSet.getString("EventD"));
                report.setId(resultSet.getString("AltID"));
                System.out.println("Report retrieved successfully.");
            } else {
                System.out.println("No report found with ID " + Id);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving report: " + e.getMessage());
        }
    }

    @Override
    public void deleteReport(String Id) {
        String sql = "DELETE FROM Reports WHERE ReportID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Id);
            pstmt.executeUpdate();
            System.out.println("Report deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting report: " + e.getMessage());
        }
    }
}
