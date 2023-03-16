import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class UserInput {

    // make sure input is string date in MM/dd/yyyy format
    public String date(String gradYear, String userInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //set the date format
        dateFormat.setLenient(false); // throw Parse Exception if input is not in correct format
        Date date;  // date object

        try {
            date = dateFormat.parse(userInput); // parse input and convert to date object
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // convert to local date object to compare to current date
            if (userInput.length() != 10 || localDate.isAfter(LocalDate.now()) || localDate.isBefore(LocalDate.of(Integer.parseInt(gradYear) - 21, 12, 31))) {
                return null;
            }
        } catch (ParseException e) { // if input is not in correct format, display error message and restart the while loo
            return null;
        }
        return dateFormat.format(date); // convert date object to string
    }

    // make sure input is 4 digits number and within range of graduating year that makes sense
    public String year(String userInput) {
        String yearInput = null; // user input
        int value; // make sure input is numeric
        try {
            value = Integer.parseInt(userInput);
            if (value < 1900 || value > 2100) {
                return null;
            }
        } catch (NumberFormatException e){
            return null;
        }
        return userInput;
    }

    // make sure input is length 10
    public String reportID(String UserInput) {
        String reportIDInput = null; // user input
        String cancel = "cancel"; // cancel option
        boolean isValid = false; // for while loop when input is not numeric or not 9 digits
        while (!isValid) {
            reportIDInput = UserInput;
            reportIDInput = reportIDInput.toLowerCase();
            if (reportIDInput.equals(cancel)) {
                return cancel;
            }
            if (reportIDInput.length() == 10) { // make sure there are 9 digits
                isValid = true;
            } else {
                System.out.println("Invalid. Please try again with 10 characters.");
            }
        }
        return reportIDInput;
    }
}

