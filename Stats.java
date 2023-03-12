import java.sql.*;
import java.util.Scanner;

public class Stats {
    String title = "Statistics";
    Scanner scan = new Scanner(System.in);

    public Stats (){
        System.out.println(title);
        System.out.println();
        displayAllReports();
        displayReportsStartingFrom2020();
        displayReportsWithMHIGreaterThan5();
        displayReportsWhereIdentityWasAFactor();
        System.out.println();

        userInput();

//        displayFilteredReports();
    }

    public void userInput(){
        String filterCriteria = "";
        while(!filterCriteria.equalsIgnoreCase("no")){
            System.out.println("What would you like to filter by? Please type in date, location, or graduation class.");
            filterCriteria = scan.nextLine();

            if (filterCriteria.equalsIgnoreCase("date")) {
                System.out.println("You inputted in date.");
                //specifc date filter
            } else if (filterCriteria.equalsIgnoreCase("location")){
                System.out.println("You inputted in location.");
                //specific location filter
            } else if (filterCriteria.equalsIgnoreCase("graduation class")){
                System.out.println("You inputted in graduation class.");
                //specific graduation filter
            } else {
                System.out.println("Invalid filter criteria input, please try again.");
            }
            System.out.println("Would you like to filter again? Type in yes or no.");
            filterCriteria = scan.nextLine();
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

    public void displayReportsStartingFrom2020(){
        System.out.println("Total number of reports starting from 2020: " + countRows("Reports", "ID", "Date > 12/31/2019"));
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
