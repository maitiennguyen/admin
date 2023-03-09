public class EditMHIText extends Editor{

    public EditMHIText(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setMHIText(this.userInput);
    }
}
