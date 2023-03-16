import java.util.ArrayList;

public class FileReport {
    protected Report report;
    protected ArrayList<Command> commandList = new ArrayList<Command>();
    protected UserInput userInput = new UserInput();

    public int createReport(String gradYear, String incidentDate, String mhi, String mhiT, String identityYN, String identityT, String location, String EventDes) {
        this.report = new Report();

        String year = userInput.year(gradYear);
        if (year == null || year.isEmpty()) {
            return 1;
        }

        String date = userInput.date(year, incidentDate);
        if (date == null || date.isEmpty()) {
            return 2;
        }

        if (mhi.isEmpty()) {
            return 3;
        }
        String reportID = this.generateID();

        Command fillReport = new FillReportCommand(this.report, reportID, gradYear, incidentDate, mhi, mhiT, identityYN, identityT, location, EventDes);
        Command saveReport = new SaveReportCommand((this.report));

        this.commandList.add(fillReport);
        this.commandList.add(saveReport);

        this.executeEdits();

        return 0;
    }

    public Report getReport() {
        return this.report;
    }

    protected void addEdit(Command edit) {
        commandList.add(edit);
    }

    protected void executeEdits() {
        for (Command edit : commandList) {
            edit.execute();
        }
    }

    // generate random report ID String of length 10, case-sensitive
    protected String generateID() { // https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) { // generate a random number between 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index)); // add Character one by one in end of sb
        }
        return sb.toString();
    }
}
