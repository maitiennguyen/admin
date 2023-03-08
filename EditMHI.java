public class EditMHI extends Editor{

    public EditMHI(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setMHI(this.userInput);
    }
}
