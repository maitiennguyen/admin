import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public interface Filter {
    void readThroughReportData();
    void filterStatistics();
    void displayFilteredStatistics();
}
