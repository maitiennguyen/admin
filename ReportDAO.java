import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ReportDAO implements AutoCloseable{
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

    public Connection getConnection() {
        return conn;
    }

    public static ResultSet executeQuery(Connection conn, String table) throws SQLException {
        ArrayList<String> columns = new ArrayList<String>();
        PreparedStatement stmt = conn.prepareStatement("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?");
        stmt.setString(1, table);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            if (!columnName.equals("ID") && !columnName.equals("Class") && !columnName.equals("MHI") && !columnName.equals("Date") && !columnName.equals("Identity_yn") && !columnName.equals("location")) {
                columns.add(columnName);
            }
        }
        String selectClause = String.join(", ", columns);
        String formattedQuery = String.format("SELECT %s FROM %s", selectClause, table);
        PreparedStatement queryStatement = conn.prepareStatement(formattedQuery);
        return queryStatement.executeQuery();
    }


    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
