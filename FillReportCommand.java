public class FillReportCommand implements Command{
    private Report report;
    private String ID;
    private String gradYear;
    private String incidentDate;
    private String mhi;
    private String mhiT;
    private String identityYN;
    private String identityT;
    private String location;
    private String EventDes;

    public FillReportCommand(Report report, String ID, String gradYear, String incidentDate, String mhi, String mhiT, String identityYN, String identityT, String location, String EventDes) {
        this.report = report;
        this.ID = ID;
        this.gradYear = gradYear;
        this.incidentDate = incidentDate;
        this.mhi = mhi;
        this.mhiT = mhiT;
        this.identityYN = identityYN;
        this.identityT = identityT;
        this.location = location;
        this.EventDes = EventDes;
    }


    @Override
    public void execute() {
        this.report.setId(this.ID);
        this.report.setGradYear(this.gradYear);
        this.report.setDate(this.incidentDate);
        this.report.setMHI(this.mhi);
        this.report.setMHIText(this.mhiT);
        this.report.setIdentityYN(this.identityYN);
        this.report.setIdentityText(this.identityT);
        this.report.setLocation(this.location);
        this.report.setEventDes(this.EventDes);
    }
}
