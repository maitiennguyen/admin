public class EditEventDes extends Editor{

    public EditEventDes(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setEventDes(userInput);
    }
}
