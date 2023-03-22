import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseQuery implements Filter{
    private String shortAnswersTable;
    private String parsedInfoTable;
    private List<Filter> filters;

    public BaseQuery(String shortAnswersTable, String parsedInfoTable) {
        this.shortAnswersTable = shortAnswersTable;
        this.parsedInfoTable = parsedInfoTable;
        this.filters = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    protected abstract String getJoinCondition();

    public ResultSet executeQuery(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sqlQuery());
    }

    @Override
    public String sqlQuery() {
        StringBuilder sql = new StringBuilder("SELECT * FROM " + this.shortAnswersTable + " JOIN " + this.parsedInfoTable + " ON " + getJoinCondition());
        if (!filters.isEmpty()) {
            sql.append(" WHERE ");
            for (int i = 0; i < filters.size(); i++) {
                if (i > 0) {
                    sql.append(" AND ");
                }
                sql.append(filters.get(i).sqlQuery());
            }
        }
        return sql.toString();
    }

}
