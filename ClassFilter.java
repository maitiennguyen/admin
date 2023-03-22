public class ClassFilter extends AddOns {
    private String column;
    private int value;

    public ClassFilter(String column, int value) {
        super("ShortAnswers", "ParsedInfo");
        this.column = column;
        this.value = value;
    }

    @Override
    public String sqlQuery() {
        return column + " = " + value;
    }

    @Override
    protected String getJoinCondition() {
        return "ShortAnswers.ID = ParsedInfo.ID";
    }
}
