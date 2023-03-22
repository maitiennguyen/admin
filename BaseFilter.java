import java.util.ArrayList;
import java.util.List;

public class BaseFilter implements Filter {

    private String shortAnswersTable;
    private String parsedInfoTable;
    private List<Filter> filters;

    public BaseFilter(String shortAnswersTable, String parsedInfoTable) {
        this.shortAnswersTable = shortAnswersTable;
        this.parsedInfoTable = parsedInfoTable;
        this.filters = new ArrayList<>();
    }

    protected String getJoinCondition() {
        return "ShortAnswers.ID = ParsedInfo.ID";
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
