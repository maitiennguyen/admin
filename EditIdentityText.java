public class EditIdentityText extends Editor{

    public EditIdentityText(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setIdentityText(this.userInput);
    }
}
