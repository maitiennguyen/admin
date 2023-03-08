import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public interface Filter {
    int size();
    void readThroughReportData();
    void filterStatistics();
    void displayFilteredStatistics();
}
