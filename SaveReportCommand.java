public class SaveReportCommand implements Command{
    Report report;

    public SaveReportCommand(Report report) {
        this.report = report;
    }

    @Override
    public void execute() {
        // submit it to database
        ReportDAO DAO = new ReportDAO();
        ReportDAO.makeDBConnection();
        new Save().saveReportShortAnswers(this.report); //implementing save method
        new Save().saveReportLongAnswers(this.report);
    }
}
