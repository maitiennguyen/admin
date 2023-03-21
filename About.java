public class About extends MoreInfo{
    String title = "About";
    String whySRASDescription = "Our team created Student Reports and Statistics (SRAS) for college students to anonymously " +
            "report and track data on crime and sexual harassment activity that has occurred on campus. SRAS aims to " +
            "provide transparent information and report tracking for students to ensure that all students have access " +
            "to accurate and relevant information about campus safety.\n" +
            "\n" +
            "We understand that the current data that’s released by Campus Safety is not the most accurate representation " +
            "of the many incidents that have occurred on campus. This mainly has to do with the fact that Campus Safety is " +
            "only allowed to report certain things to the federal government. Our hope is that with this platform, students " +
            "have access to better incident information and report submissions while still maintaining their anonymity. \n" +
            "\n" +
            "That being said, our platform is not replacing any of the resources that already exist on campus. We want " +
            "our users to think of our platform as an additional resource, and it is why we have done our best to include " +
            "other on campus and off campus resources.\n";
    String ourGoalsDescription = "Our primary goal is to improve campus safety by empowering students with the knowledge " +
            "and resources they need to make informed decisions about their activities. We believe we accomplish that by " +
            "providing anonymous reporting, displaying transparent information, and listing other additional resources on " +
            "and off campus.  \n" +
            "\n" +
            "Another one of our goals is to be as user friendly as possible, especially when it comes to filling out a " +
            "report. We know how difficult it can be to describe a personal experience that may have been more negative " +
            "than positive, and that is why we only require three questions to be answered. If at any time the user feels " +
            "that they cannot finish the report or decide that they no longer want to file the report, they can either press " +
            "the back or exit button and rest assured that our program will not save anything they previously filled out. \n";
    String dataUsageDescription = "Our data comes from the database that stores every successfully submitted report. " +
            "We only use certain information for that data. For example, total number of reports, average mental " +
            "health impact, and how many incidents occurred between certain dates. SRAS has no intention of sharing " +
            "all of the content that’s in each report after they’ve been submitted to our database. Users should rest " +
            "assured that their personal text entries will not be displayed on our platform.  We will only use relevant " +
            "data to give a more accurate reflection of crime and sexual harassment activity that’s happened on campus. ";
    String foundersAndCurrentTeamDescription = "Our current team consists of its three founders: \n" +
            "\n" +
            "Mai Nguyen (she/her) \n" +
            "Major: Computer Science \n" +
            "Minor: Molecular Biology \n" +
            "Class of 2024 \n" +
            "\n" +
            "Whitner Reichman (she/her/they/them) \n" +
            "Major: Polyoptic Studies \n" +
            "Minor: Music \n" +
            "Class of 2024 \n" +
            "\n" +
            "Judinelly Gonzalez (she/her) \n" +
            "Major: Computer Science \n" +
            "Minor: Studio Art \n" +
            "Class of 2025 \n";

    String howToNavigateHeading = "How do I navigate the Student Reports & Statistics platform? \n";

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
