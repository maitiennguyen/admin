public class DeleteReportCommand implements Command{
    Save delete = new Save();
    Report report;

    public DeleteReportCommand(Report report) {
        this.report = report;
    }

    @Override
    public void execute() {
        delete.deleteReport(this.report.getId());
    }
}
