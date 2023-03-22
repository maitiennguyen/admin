public class IdentityYNFilter extends BaseQuery{
    private String column;
    private String value;

    public IdentityYNFilter(String column, String value) {
        super("ShortAnswers", "ParsedInfo");
        this.column = column;
        this.value = value;
    }

    @Override
    protected String getJoinCondition() {
        return "ShortAnswers.ID = ParsedInfo.ID";
    }

    @Override
    public String sqlQuery() {
        return column + " = '" + this.value + "'";
    }
}
