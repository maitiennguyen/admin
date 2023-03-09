public class EditIdentity extends Editor{

    public EditIdentity(Report report, String userInput) {
        this.report = report;
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        this.report.setIdentityYN(userInput);
    }
}
