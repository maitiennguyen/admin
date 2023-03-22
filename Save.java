import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Save extends ReportDAO implements sqlDataMethods
{
    @Override
    public void saveReportShortAnswers(Report report)
    {
        // change date string type to object type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.parse(report.getDate(), formatter);
        Date date = Date.valueOf(localDate);
        try {
            String sql = "INSERT INTO ShortAnswers (Grad, MHI, Date, IdentityYN, ID) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, report.getGradYear());
            statement.setString(2, report.getMHI());
            statement.setDate(3, date);
            statement.setString(4, report.getIdentityYN());
            statement.setString(5, report.getId());

            statement.executeUpdate();
            System.out.println("Report submitted and saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public void saveReportLongAnswers(Report report) {
        try {
            String sql = "INSERT INTO LongAnswers (MHIT, IdentityTxt, Location, EventD, ID) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, report.getMHIText());
            statement.setString(2, report.getIdentityText());
            statement.setString(3, report.getLocation());
            statement.setString(4, report.getEventDes());
            statement.setString(5, report.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public void saveReportParsedInfo(Report report) {
        // change date string type to object type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.parse(report.getDate(), formatter);
        Date date = Date.valueOf(localDate);
        try {
            String sql = "INSERT INTO ParsedInfo (Location, Identity, Class, ID) VALUES (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, new ParseInfo().parsingLocation(report.getLocation()));
            statement.setString(2, new ParseInfo().ParseIdentity(report.getIdentityText()));
            statement.setInt(3, calculateSaveClass(report.getGradYear(), date));
            statement.setString(4, report.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public Report retrieveReport(String Id)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //set the date format
        try
        {
            String sql = "SELECT * FROM ShortAnswers INNER JOIN LongAnswers ON ShortAnswers.ID = LongAnswers.ID WHERE ShortAnswers.ID = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, Id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Report report = new Report();
                report.setGradYear(resultSet.getString("Grad"));
                report.setMHI(resultSet.getString("MHI"));
                report.setDate(dateFormat.format(resultSet.getDate("Date")));
                report.setIdentityYN(resultSet.getString("IdentityYN"));
                report.setMHIText(resultSet.getString("MHIT"));
                report.setIdentityText(resultSet.getString("IdentityTxt"));
                report.setLocation(resultSet.getString("Location"));
                report.setEventDes(resultSet.getString("EventD"));
                report.setId(resultSet.getString("ID"));
                System.out.println("Report retrieved successfully.");
                return report;
            }
            else
            {
                System.out.println("No report found with ID " + Id);
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving report: " + e.getMessage());
        }
        return null;
    }

    public void updateReport(Report report) {
        // change date string type to object type
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.parse(report.getDate(), formatter);
        Date date = Date.valueOf(localDate);
        try {
            String sql1 = "UPDATE ShortAnswers SET Grad = ?, MHI = ?, Date = ?, IdentityYN = ? WHERE ID = ?";
            PreparedStatement updateTable1Statement = conn.prepareStatement(sql1);
            updateTable1Statement.setString(1, report.getGradYear());
            updateTable1Statement.setString(2, report.getMHI());
            updateTable1Statement.setDate(3, date);
            updateTable1Statement.setString(4, report.getIdentityYN());
            updateTable1Statement.setString(5, report.getId());

            String sql2 = "UPDATE LongAnswers SET MHIT = ?, IdentityTxt = ?, Location = ?, EventD = ? WHERE ID = ?";
            PreparedStatement updateTable2Statement = conn.prepareStatement(sql2);
            updateTable2Statement.setString(1, report.getMHIText());
            updateTable2Statement.setString(2, report.getIdentityText());
            updateTable2Statement.setString(3, report.getLocation());
            updateTable2Statement.setString(4, report.getEventDes());
            updateTable2Statement.setString(5, report.getId());

            String sql3 = "UPDATE ParsedInfo SET LOCATION = ?, Identity = ? WHERE ID = ?";
            PreparedStatement updateTable3Statement = conn.prepareStatement(sql3);
            updateTable3Statement.setString(1, new ParseInfo().parsingLocation(report.getLocation()));
            updateTable3Statement.setString(2, new ParseInfo().ParseIdentity(report.getIdentityText()));
            updateTable3Statement.setString(3, report.getId());

            updateTable1Statement.executeUpdate();
            updateTable2Statement.executeUpdate();
            updateTable3Statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating report: " + e.getMessage());
        }
    }

    @Override
    public void deleteReport(String Id) {
        String sql1 = "DELETE FROM ShortAnswers WHERE ID = ?";
        String sql2 = "DELETE FROM LongAnswers WHERE ID = ?";
        String sql3 = "DELETE FROM ParsedInfo WHERE ID = ?";
        try {
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            PreparedStatement pstmt3 = conn.prepareStatement(sql3);

            pstmt1.setString(1, Id);
            pstmt2.setString(1, Id);
            pstmt3.setString(1, Id);

            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            pstmt3.executeUpdate();

            System.out.println("Report deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting report: " + e.getMessage());
        }
    }

    public int calculateSaveClass(String gradYear, Date date)
    {
        int yearDifference = Integer.parseInt(gradYear) - (date.getYear() + 1900);
        if (yearDifference >= 0 && yearDifference <= 3)
        {
            return yearDifference;
        } else {
            return 5;
        }
    }

    public String applyFilters(String startDate, String endDate, String identity, String classYear, String IdentityYN) {
        System.out.println(startDate);
        AddOns query = new AddOns("ShortAnswers", "ParsedInfo") {
            @Override
            protected String getJoinCondition() {
                return "ShortAnswers.ID = ParsedInfo.ID";
            }
        };

        if (!startDate.isEmpty() && !endDate.isEmpty()) {
            query.addFilter(new DateFilter(startDate, endDate));
        }

        if (!identity.isEmpty()) {
            query.addFilter(new IdentityTxtFilter("ParsedInfo.Identity", identity));
        }

        if (classYear != null) {
            query.addFilter(new ClassFilter("ParsedInfo.Class", Integer.parseInt(classYear)));
        }

        if (!IdentityYN.isEmpty()) {
            query.addFilter(new IdentityYNFilter("ShortAnswers.IdentityYN", IdentityYN));
        }

        ArrayList<String> top3Locations = new ArrayList<>();
        double average = 0;
        int nReports = 0;
        try {
            ResultSet rs = query.executeQuery(conn);
            nReports = 0;
            int sum = 0;
            int count = 0;

            Map<String, Integer> valueFreqMap = new HashMap<>();
            while (rs.next()) {
                int mhiValue = Integer.parseInt(rs.getString("MHI"));
                String location = rs.getString("Location");

                //get mhi average
                sum += mhiValue;
                count++;

                //get total number of reports
                nReports++;

                //get top 3 locations
                if (valueFreqMap.containsKey(location)) {
                    valueFreqMap.put(location, valueFreqMap.get(location) + 1);
                } else {
                    valueFreqMap.put(location, 1);
                }
            }
            average = (double) sum / count;

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(valueFreqMap.entrySet());
            Collections.sort(sortedEntries, Map.Entry.comparingByValue(Comparator.reverseOrder()));
            int count2 = 0;
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                top3Locations.add(entry.getKey());
                count2++;
                if (count2 == 3) {
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error filtering data: " + e.getMessage());
        }

        String text = "Most frequent locations: " + top3Locations + "\n\nAverage MHI Number: " + average + "\n\nTotal number of reports: " + nReports;
        return text;
    }

/*
    public static void main(String[] args) {
        Save test = new Save();
        System.out.println(test.applyFilters("2020-01-01", "2021-01-01", "female", "0", "yes"));
    }
*/

}




