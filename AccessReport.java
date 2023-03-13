import java.util.ArrayList;

public class AccessReport extends FileReport{
    protected String reportID;

    public void showReport() {
        System.out.println("Access Report (Enter 'cancel' to return home)\n");
        reportID = this.reportIDPrompt();
        this.report = save.retrieveReport(reportID); // retrieve report
        this.editReport(); // display and edit report
        save.updateReport(this.report); // update edit if any
        System.out.println("Report saved.");
    }

    private String reportIDPrompt() {
        System.out.println("Enter report ID: ");
        return this.userInput.reportID();
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
        System.out.println("9. Delete");
        System.out.println("10. Done");
    }

    public void editReport() {
        String menuInput;
        boolean done = false;

        while (!done) {
            this.displayReport();
            System.out.println("Enter a number to edit corresponding field. Enter 9 to delete report. Enter 10 to return or save edit(s).");
            menuInput = this.userInput.menuOpt(10);
            switch (menuInput) {
                case "1" -> this.gradYearPrompt();
                case "2" -> this.datePrompt();
                case "3" -> this.mhiPrompt();
                case "4" -> this.mhiTextPrompt();
                case "5" -> this.identityPrompt();
                case "6" -> this.identityTextPrompt();
                case "7" -> this.locationPrompt();
                case "8" -> this.eventDesPrompt();
                case "9" -> this.save.deleteReport(this.report.getId());
                case "10" -> done = true;
            }
        }
        this.executeEdits();
    }
}
