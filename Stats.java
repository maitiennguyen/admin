public class Stats {
    String title = "Statistics";
    int size;

    public Stats (){
        System.out.println(title);
        size = 0;
        displayAllReports();
        displayFilteredReports();
    }

    public int getSize() { //to get the total number of reports as a number
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void displayAllReports(){ //displays the default number of statistics
        System.out.println("Total number of reports: " + getSize());
    }

    public void displayFilteredReports(){ //will be more specified based off of filter
        System.out.println("Total number of filtered reports: ");
    }

    public static void main(String[] args) {
        Stats test1 = new Stats();
    }
}
