public class EditLocation extends Editor{

    public EditLocation(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setLocation(this.userInput);
    }
}
