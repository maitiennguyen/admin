public class RetrieveReportCommand implements Command {
    private Report report;

    @Override
    public void execute() {
        this.report = new Save().retrieveReport(report.getId());

    }

    public Report getReport() {
        return report;
    }
}
