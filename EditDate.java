public class EditDate extends Editor{

    public EditDate(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setDate(this.userInput);
    }
}
