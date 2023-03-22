import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFilter extends BaseQuery {
    private String startDate;
    private String endDate;

    public DateFilter(String startDate, String endDate) {
        super("ShortAnswers", "ParsedInfo");
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    protected String getJoinCondition() {
        return "ShortAnswers.ID = ParsedInfo.ID";
    }

    @Override
    public String sqlQuery() {
        return "ShortAnswers.Date BETWEEN '" + this.startDate + "' AND '" + this.endDate + "'";    }
}
