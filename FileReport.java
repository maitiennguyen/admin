import java.util.ArrayList;

public class FileReport {
    protected Report report;
    protected ArrayList<Editor> editList = new ArrayList<Editor>();
    protected UserInput userInput = new UserInput();
    protected Save save = new Save();
    private String gradYear;

    public void createReport() {
        this.report = new Report();

        System.out.println("File A Report (Enter 'cancel' to return home)\n");

        if (this.gradYearPrompt() || // grad year
                this.datePrompt() || // date
                this.mhiPrompt() || // mental health impact
                this.mhiTextPrompt() || // mental health impact description
                this.identityPrompt() || // identity y/n
                this.identityTextPrompt() || // describe how identity was targeted
                this.locationPrompt() || // location
                this.eventDesPrompt() // event description
        ) {
            System.out.println("Report canceled.");
            return;
        }

        this.executeEdits(); // execute all edits, fill out the report

        this.report.setId(generateID());// generate random report id

        // submit it to database
        ReportDAO DAO = new ReportDAO();
        ReportDAO.makeDBConnection();
        save.saveReport(this.report); //implementing save method

        System.out.println("Report ID: " + this.report.getId() + "\nPlease save the report ID for future access.");
    }

    public Report getReport() {
        return this.report;
    }

    protected void addEdit(Editor edit) {
        editList.add(edit);
    }

    protected void executeEdits() {
        for (Editor edit : editList) {
            edit.execute();
        }
    }

    protected boolean gradYearPrompt() {
        System.out.println("Enter your graduation year YYYY (required): ");
        String yearInput = userInput.year();
        if (yearInput.equals("cancel")) {
            return true;
        }
        Editor editGradYear = new EditGradYear(this.report, yearInput);
        this.addEdit(editGradYear);
        this.gradYear = yearInput;
        return false;
    }

    protected boolean datePrompt() {
        System.out.println("Enter the date of incident MM/dd/yyyy (required): ");
        String dateInput = userInput.date(this.gradYear);
        if (dateInput.equals("cancel")) {
            return true;
        }
            Editor editDate = new EditDate(this.report, dateInput);
        this.addEdit(editDate);
        return false;
    }

    protected boolean mhiPrompt() {
        System.out.println("On a scale of 0 to 10, rate the impact of the incident on your mental health (required): ");
        String mhiInput = userInput.mhi();
        if (mhiInput.equals("cancel")) {
            return true;
        }
        Editor editMHI = new EditMHI(this.report, mhiInput);
        this.addEdit(editMHI);
        return false;
    }

    protected boolean mhiTextPrompt() {
        System.out.println("Share your mental health experience (optional - enter to skip): ");
        String mhiTextInput = userInput.text();
        if (mhiTextInput.equals("cancel")) {
            return true;
        }
        Editor editMHIText = new EditMHIText(this.report, mhiTextInput);
        this.addEdit(editMHIText);
        return false;
    }

    protected boolean identityPrompt() {
        System.out.println("Do you think your identities were being targeted? y or n (optional - enter to skip): ");
        String identityInput = userInput.identityYN();
        if (identityInput.equals("cancel")) {
            return true;
        }
        Editor editIdentity = new EditIdentity(this.report, identityInput);
        this.addEdit(editIdentity);
        return false;
    }

    protected boolean identityTextPrompt() {
        System.out.println("If yes, which aspect(s) of your identity do you feel were relevant to this event? (optional - enter to skip): ");
        String identityTextInput = userInput.text();
        if (identityTextInput.equals("cancel")) {
            return true;
        }
        Editor editIdentityText = new EditIdentityText(this.report, identityTextInput);
        this.addEdit(editIdentityText);
        return false;
    }

    protected boolean locationPrompt() {
        System.out.println("Enter location of incident (optional - enter to skip): ");
        String locationInput = userInput.text();
        if (locationInput.equals("cancel")) {
            return true;
        }
        Editor editLocation = new EditLocation(this.report, locationInput);
        this.addEdit(editLocation);
        return false;
    }

    protected boolean eventDesPrompt() {
        System.out.println("Event description (optional - enter to skip): ");
        String eventDesInput = userInput.text();
        if (eventDesInput.equals("cancel")) {
            return true;
        }
        Editor editEventDes = new EditEventDes(this.report, eventDesInput);
        this.addEdit(editEventDes);
        return false;
    }

    // generate random report ID String of length 10, case-sensitive
    protected String generateID() { // https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) { // generate a random number between 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index)); // add Character one by one in end of sb
        }
        return sb.toString();
    }
}
