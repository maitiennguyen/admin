public class About extends MoreInfo{
    String title = "About";
    String howToNavigateHeading = "How do you navigate the Student Reports & Statistics platform?";
    //use '%n' when I want a new line in terminal
    String howToNavigateDescription = "When a user uses the SRAS platform, a home page will appear and they will have the " +
            "option to input which of the six features they would like to access. %nIf the user inputs 1, they will access " +
            "Campus Statistics; if the user inputs 2, they will access Additional Resources; if the user inputs 3, they will access " +
            "%nAbout (the current option you are in); if the user inputs 4, they will access File Report; if the user " +
            "inputs 5, they will access Access Report; and if the %nuser inputs 6, they will quit the entire program. \n" +
            "\n" +
            "Once the user has inputted their number to access one of the five features, they will be shown what’s in that " +
            "specific feature. The user then has to %nreload the program to access a different feature. \n" +
            "\n" +
            "It is important to note that a few of the features (File Report and Access Report) have very specific user input " +
            "formatting. Simply follow the instructions %nthat are displayed for you when navigating through those features.";

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
