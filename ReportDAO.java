import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ReportDAO {
    static Connection conn = null;
    static PreparedStatement statement = null;

    public ReportDAO()
    {
        makeDBConnection();
    }

    public static void makeDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/SRAS", "root", "root");
            if(conn != null){
//                System.out.println("success");
            } else{
//                System.out.println("fail");
            }
        } catch(SQLException e){
            e.printStackTrace();
            return;
        }
    }
}
