public class About extends MoreInfo{
    String title = "About";
    String whySRASDescription = "Our team created Student Reports and Statistics (SRAS) for college students to anonymously " +
            "report and track data on crime and sexual harassment activity that has occurred on campus. SRAS aims to provide " +
            "transparent information and report tracking for students to ensure that all students have access to accurate and " +
            "relevant information about campus safety.";
    String ourGoalsDescription = "Our primary goal is to improve campus safety by empowering students with the knowledge and " +
            "resources they need to make informed decisions about their activities.";
    String dataUsageDescription = "We will use the data to...";
    String foundersAndCurrentTeamDescription = "Our current team consists of its three founders: Judinelly Gonzalez " +
            "(class of 2025), Mai Nguyen (class of 2026), and Whitner Reichman (class of 2026)";
    String howToNavigateHeading = "How do I navigate the Student Reports & Statistics platform? \n";
    //use '%n' when I want a new line in terminal
    String howToNavigateDescription = "\nWhen a user uses the SRAS platform, a home page will appear and they will have the " +
            "option to click on one of five buttons. The user should then click on the button of their liking to explore what that " +
            "page has to offer. Whenever the user has finished viewing or interacting with the page they're in, all they have to " +
            "do is click the back button or exit the program altogether. It is a pretty user friendly program.";

    String howDoIFileAReportHeading = "How do I file a report? \n";
    String howDoIFileAReportDescription = "\nAfter the program loads and displays the SRAS’ home page, the user must click on " +
            "the ‘File Report’ button. The program will then take them to our ‘File Report’ page and the user must answer " +
            "all the fields that have a star next to them (a total of three fields). The user will then decide to answer " +
            "any of the other fields or leave them blank. Once done, the user must click on the ‘Submit’ button at the " +
            "bottom of the page. A random Report ID will be generated and the user must save this ID somewhere in order " +
            "to later re-access their report.";
    String howDoIReAccessAReportHeading = "How do I re-access a report? \n";
    String howDoIReAccessAReportDescription = "\nAfter the program loads and displays the SRAS’ home page, the user must " +
            "click on the ‘Access Report’ button. The program will then take them to our Access Report’ page and the " +
            "user must enter the Report ID that was generated for them after having submitted a report. If the user " +
            "has the correct ID, then it will display their previously submitted report and allow them to edit/check " +
            "their report. If not, then it will give them an error message to try again.\n";
    String howCurrentAreTheStatisticsHeading = "How current are SRAS' statistics? \n";
    String howCurrentAreTheStatisticsDescription = "\nOur statistics automatically update every time someone submits a " +
            "report. We’ve set up our statistics to reflect that. ";

    @Override
    public void displayAllInfo() {
        System.out.println(title);
        System.out.println();
        System.out.println(howToNavigateHeading);
        System.out.println();
        System.out.printf(howToNavigateDescription);
        System.out.println();
    }
}
