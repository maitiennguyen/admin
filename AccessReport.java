import java.util.ArrayList;

public class AccessReport extends FileReport{
    protected String reportID;

    public AccessReport(Report report) { // DELETE
        this.report = report;
    }

    public void showReport() {
        System.out.println("Access Report (Enter 'cancel' to return home)\n");
        reportID = this.reportIDPrompt();
        // this.report = getReport
        this.displayReport(); // display report info
        this.editReport();
        //submit to database
        System.out.println("Report saved.");
        this.userInput.close();
    }

    private String reportIDPrompt() {
        System.out.println("Enter report ID: ");
        String reportIDInput = this.userInput.reportID();
        return reportIDInput;
    }

    private void displayReport() {
        System.out.println("Report ID: " + this.report.getId());
        System.out.println("1. Graduation year (required): " + this.report.getGradYear());
        System.out.println("2. Date of incident (required: " + this.report.getDate());
        System.out.println("3. Mental health impact scale (required): " + this.report.getMHI());
        System.out.println("4. Mental health impact experience: " + this.report.getMHIText());
        System.out.println("5. Directed towards specific identities?: " + this.report.getIdentityYN());
        System.out.println("6. Provided identities: " + this.report.getIdentityText());
        System.out.println("7. Location: " + this.report.getLocation());
        System.out.println("8. Event description: " + this.report.getEventDes());
        System.out.println("9. Done");
    }

    public void editReport() {
        String menuInput;
        boolean done = false;

        while (!done) {
            System.out.println("\nEnter a number to edit corresponding field. Enter 9 to save edit(s).");
            menuInput = this.userInput.menuOpt(9);
            switch (menuInput) {
                case "1" -> this.gradYearPrompt();
                case "2" -> this.datePrompt();
                case "3" -> this.mhiPrompt();
                case "4" -> this.mhiTextPrompt();
                case "5" -> this.identityPrompt();
                case "6" -> this.identityTextPrompt();
                case "7" -> this.locationPrompt();
                case "8" -> this.eventDesPrompt();
                case "9" -> done = true;
            }
        }
        this.executeEdits();
    }

    public static void main(String[] args) { //DELETE
        Report report = new Report();
        report.setGradYear("2020");
        report.setDate("01/01/2001");
        report.setMHI("5");
        report.setMHIText("");
        report.setIdentityYN("y");
        report.setIdentityText("hello world");
        report.setLocation("home");
        report.setEventDes("");

        AccessReport test = new AccessReport(report);
        test.editReport();
        System.out.println(report.getGradYear() + " " + report.getDate() + " " + report.getMHI() + " " + report.getMHIText() + " " + report.getIdentityYN() + " " + report.getIdentityText() + " " + report.getLocation() + " " + report.getEventDes());
    }
}
