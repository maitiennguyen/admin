import java.sql.*;
import java.util.Scanner;

public class Stats {
    String title = "Campus Statistics";
    Scanner scan = new Scanner(System.in);

    public Stats (){
        System.out.println(title);
        System.out.println();
        displayAllReports();
        displayReportsStartingFrom2020();
        displayReportsWithMHIGreaterThan5();
        displayReportsWhereIdentityWasAFactor();
        System.out.println();

        filterYN();

//        displayFilteredReports();
    }
    public void filterYN(){
        String filterYNAnswer = "";

        while (true){
            System.out.println("Would you like to filter through our statistics? Please type in yes or no.");
            filterYNAnswer = scan.nextLine();
            if (filterYNAnswer.equals("yes")){
                filterCriteriaUserInput();
                break;
            } else if (filterYNAnswer.equals("no")){
                break;
            } else {
                System.out.println("Invalid user input. Please try again.");
            }
        }
    }

    public void filterCriteriaUserInput() {
        String filterCriteria = "";
        boolean validCriteria = false;

        while (!validCriteria) {
            System.out.println("What would you like to filter by? Please type in date, location, or graduation class.");
            filterCriteria = scan.nextLine();

            if (filterCriteria.equals("date")) {
                System.out.println("You inputted in date.");
                //specifc date filter
                validCriteria = true;
            } else if (filterCriteria.equals("location")) {
                System.out.println("You inputted in location.");
                //specific location filter
                validCriteria = true;
            } else if (filterCriteria.equals("graduation class")) {
                System.out.println("You inputted in graduation class.");
                //specific graduation filter
                validCriteria = true;
            } else if (filterCriteria.equals("no")){
                return;
            } else {
                System.out.println("Invalid filter criteria input, please try again.");
            }

            boolean validAnswer = false;
            while (!validAnswer) {
                System.out.println("Would you like to filter again? Type in yes or no.");
                String filterAgainResponse = scan.nextLine();
                if (filterAgainResponse.equals("yes")) {
                    validAnswer = true;
                    validCriteria = false;
                } else if (filterAgainResponse.equals("no")) {
                    return;
                } else {
                    System.out.println("Invalid response. Please try again.");
                }
            }
        }
    }

    public int countRows(String tableName, String columnName, String condition) { //to get the total number of reports as a number
        int count = 0;
        String query = "SELECT COUNT(" + columnName + ") FROM " + tableName + " WHERE " + condition;
        ReportDAO.makeDBConnection();

        try (PreparedStatement pstmt = ReportDAO.conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery(query);
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
//            System.out.println("Count counted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error counting number of reports: " + e.getMessage());
        }
        return count;
    }

    public void displayAllReports(){ //displays the default number of statistics
        System.out.println("Total number of reports: " + countRows("Reports", "ID", "MHI > 0"));
    }

    public void displayReportsStartingFrom2020(){ //date is in a string and that's why it doesn't compare dates
        System.out.println("Total number of reports starting from 2020: " + countRows("Reports", "Date", "Date > 12/31/2019"));
    }

    public void displayReportsWithMHIGreaterThan5(){
        System.out.println("Total number of reports with a mental health impact > 5: " + countRows("Reports", "ID", "MHI > 5"));
    }

    public void displayReportsWhereIdentityWasAFactor(){
        System.out.println("Total number of reports where identity was a factor: " + countRows("Reports", "IdentityYN", "IdentityYN = 'y'"));
    }

//    public String getFilterInput(){
//        String filterInput;
//    }

//    public void displayFilteredReports(){ //will be more specified based off of filter
//        System.out.println("Total number of filtered reports: ");
//    }

}
