import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public interface Filter {
    int size(); //returns the number of items in the list but don't think we're using a list
    void readThroughReportData();
    void filterStatistics();
    void displayFilteredStatistics();
}
