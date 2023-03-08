public class EditGradYear extends Editor{

    public EditGradYear(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setGradYear(this.userInput);
    }
}
