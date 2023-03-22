public class DateFilter extends AddOns {
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
