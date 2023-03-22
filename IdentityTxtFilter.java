public class IdentityTxtFilter extends BaseQuery{
    private String column;
    private String word;

    public IdentityTxtFilter(String column, String word) {
        super("ShortAnswers", "ParsedInfo");
        this.column = column;
        this.word = word;
    }

    @Override
    protected String getJoinCondition() {
        return "ShortAnswers.ID = ParsedInfo.ID";
    }

    @Override
    public String sqlQuery() {
        return column + " LIKE '%" + word + "%'";
    }
}
