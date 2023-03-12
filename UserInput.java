import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
    private Scanner userInput;

    // constructor
    public UserInput() {
        userInput = new Scanner(System.in);
    }

    // make sure input is string text and not empty
    public String text() {
        String textInput;
        String cancel = "cancel"; // cancel option
        String str[];

        textInput = this.userInput.nextLine();
        textInput = textInput.toLowerCase();
        str = textInput.split(" "); // check if input is cancel alone even with space after it
        if (str.length == 1 && str[0].equals(cancel)) { // return cancel if user no longer wants to complete or edit the report
            return cancel;
        }
        return textInput;
    }

    // make sure input is string date in MM/dd/yyyy format
    public String date() {
        String dateInput;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //set the date format
        dateFormat.setLenient(false); // throw Parse Exception if input is not in correct format
        Date date = null;  // date object
        boolean isValid = false; // for while loop when input is not in correct format
        String cancel = "cancel"; // cancel option

        while(!isValid) {
            dateInput = this.userInput.nextLine(); // take input
            dateInput = dateInput.toLowerCase();
            if (dateInput.equals(cancel)) { // return cancel if user no longer wants to complete or edit the report
                return cancel;
            }
            try {
                date = dateFormat.parse(dateInput); // parse input and convert to date object
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // convert to local date object to compare to current date
                if (dateInput.length() == 10 && !localDate.isAfter(LocalDate.now()) && localDate.isAfter(LocalDate.of(1899,12,31))) {
                    isValid = true; // if input is in correct format, get out of while loop
                }
                else {
                    System.out.println("Invalid. Please try again in MM/dd/yyyy format, date is in the past or today, and date is after 12/31/1899.");
                }
            } catch (ParseException e) { // if input is not in correct format, display error message and restart the while loop
                System.out.println("Invalid. Please try again in MM/dd/yyyy format.");
            }
        }
        return dateFormat.format(date); // convert date object to string
    }

    // make sure input is integer and does not exceed the total available options
    public String menuOpt(int totalOpts) {
        boolean isValid = false; // for while loop when input is not in the range of menu options
        String menuOptInput = null; // user input
        String admin = "admin"; // admin access for homepage, must have no space after admin
        int value; // check if input is numeric

        while (!isValid) {
            menuOptInput = this.userInput.nextLine();
            menuOptInput = menuOptInput.toLowerCase();
            if(menuOptInput.equals(admin)) { // make sure input is larger than 0 and not greater than total # of options
                return menuOptInput;
            }
            try {
                value = Integer.parseInt(menuOptInput); // make sure the input is numeric
                if (value > 0 && value <=totalOpts) { // make the numeric input is between 0 and highest option
                    isValid = true;
                }
                else {
                    System.out.println("Invalid. Please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Please enter a valid number.");
            }
        }
        return menuOptInput;
    }

    // make sure input is 4 digits number and within range of graduating year that makes sense
    public String year() {
        String yearInput = null; // user input
        String cancel = "cancel"; // cancel option
        int value; // make sure input is numeric
        boolean isValid = false; // for while loop when input is not numeric oor not between 1900 and 2100

        while(!isValid) {
            yearInput = this.userInput.nextLine();
            yearInput = yearInput.toLowerCase();
            if (yearInput.equals(cancel)) {
                return cancel;
            }
            try {
                value = Integer.parseInt(yearInput); // make sure the input is numeric
                if (value >= 1900 && value <=2100) { // make sure the graduating class is valid
                    isValid = true;
                }
                else {
                    System.out.println("Invalid. Please try again between 1900 and 2100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Please try again in YYYY format.");
            }
        }
        return yearInput;
    }

    // make sure input is length 10
    public String reportID() {
        String reportIDInput = null; // user input
        String cancel = "cancel"; // cancel option
        boolean isValid = false; // for while loop when input is not numeric or not 9 digits
        while(!isValid) {
            reportIDInput = this.userInput.nextLine();
            reportIDInput = reportIDInput.toLowerCase();
            if (reportIDInput.equals(cancel)) {
                return cancel;
            }
            if (reportIDInput.length() == 10) { // make sure there are 9 digits
                isValid = true;
            }
            else {
                System.out.println("Invalid. Please try again with 10 characters.");
            }
        }
        return reportIDInput;
    }

    // make sure input is numeric between 0 and 10
    public String mhi() {
        String mhiInput = null; // user input
        String cancel = "cancel"; // cancel option
        float value; // make sure input is numeric
        boolean isValid = false; // for while loop when input is not numeric oor not between 1 and 10

        while(!isValid) {
            mhiInput = this.userInput.nextLine();
            mhiInput = mhiInput.toLowerCase();
            if (mhiInput.equals(cancel)) {
                return cancel;
            }
            try {
                value = Float.parseFloat(mhiInput); // make sure the input is numeric
                if (value >= 0 && value <=10 && mhiInput.length() < 4) { // make sure mhi input is valid
                    isValid = true;
                }
                else {
                    System.out.println("Invalid. Please try again between 0 and 10, to the tenth place.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Please try again between 0 and 10, to the tenth place.");
            }
        }
        return mhiInput;
    }

    // make sure input is y or n
    public String identityYN() {
        String identityInput = null; // user input
        String cancel = "cancel"; // cancel option
        String yes = "y";
        String no = "n";
        boolean isValid = false; // for while loop when input is not y or n
        while(!isValid) {
            identityInput = userInput.nextLine();
            identityInput = identityInput.toLowerCase();
            if (identityInput.equals(cancel)) {
                return cancel;
            }
            if (identityInput.equals(yes) || identityInput.equals(no) || identityInput.isEmpty()) {
                isValid = true;
            }
            else {
                System.out.println("Invalid. Please enter 'y' or 'n'");
            }
        }
        return identityInput;
    }
}
