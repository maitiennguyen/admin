import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            statement.executeUpdate();
            System.out.println("Report submitted and saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    @Override
    public void deleteReport(String reportId) {
        String sql = "DELETE FROM Reports WHERE ReportID = ?";
        ReportDAO.makeDBConnection();
        try (PreparedStatement pstmt = ReportDAO.conn.prepareStatement(sql)) {
            pstmt.setString(1, reportId);
            pstmt.executeUpdate();
            System.out.println("Report deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting report: " + e.getMessage());
        }
    }
}
