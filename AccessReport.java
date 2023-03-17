public class AccessReport {
    private Report report;
    private UserInput userInput = new UserInput();

    public int accessReport(String input) {
        String reportID = userInput.reportID(input);
        if (reportID == null) {
            return 1;
        }

        this.report = new Save().retrieveReport(reportID);
        if (this.report == null) {
            return 2;
        }

        return 0;
    }

    public Report getReport() {
        return report;
    }
}
