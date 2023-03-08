import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
    Scanner userInput;

    // constructor
    public UserInput() {
        userInput = new Scanner(System.in);
    }

    // make sure input is string text and not empty
    public String text() {
        String textInput = null;
        boolean isValid = false;
        String cancel = "cancel"; // cancel option
        String str[] = null;

        while (!isValid) {
            textInput = this.userInput.nextLine();
            textInput = textInput.toLowerCase();
            str = textInput.split(" "); // check if input is cancel even with space after it
            if (str[0].equals(cancel)) { // return cancel if user no longer wants to complete or edit the report
                return cancel;
            }
            if (!textInput.isEmpty()) {
                isValid = true;
            }
            else {
                System.out.println("Invalid. Please provide NA if not applicable.");
            }
        }
        return textInput;
    }

    // make sure input is string date in MM/dd/yyyy format
    public String date() {
        String dateInput = null;
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
                isValid = true; // if input is in correct format, get out of while loop
            } catch (ParseException e) { // if input is not in correct format, display error message and restart the while loop
                System.out.println("Invalid. Please try again in MM/dd/yyyy format.");
            }
        }
        return dateFormat.format(date); // convert date object to string
    }

    // make sure input is integer and does not exceed the total available options
    public int menuOpt(int totalOpts) {
        boolean isValid = false; // for while loop when input is not in the range of menu options
        int menuOptInput = 0; // user input

        while (!isValid) {
            while (!this.userInput.hasNextInt()) { // make sure input is integer
                this.userInput.next();
            }
            menuOptInput = this.userInput.nextInt();
            if(menuOptInput <= totalOpts && menuOptInput > 0) { // make sure input is larger than 0 anf not greater than total # of options
                isValid = true;
            }
            else {
                System.out.println("Invalid. Please enter a valid number.");
            }
        }
        return menuOptInput;
    }

    // make sure input is 4 digits number and within range of graduating year that makes sense
    public String year() {
        String yearInput = null; // user input
        String cancel = "cancel"; // cancel option
        int value = 0; // make sure input is numeric
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

    // make sure input is 10 digits
    public String reportID() {
        String reportIDInput = null; // user input
        String cancel = "cancel"; // cancel option
        int value = 0; // make sure input is numeric
        boolean isValid = false; // for while loop when input is not numeric or not 9 digits

        while(!isValid) {
            reportIDInput = this.userInput.nextLine();
            reportIDInput = reportIDInput.toLowerCase();
            if (reportIDInput.equals(cancel)) {
                return cancel;
            }
            try {
                value = Integer.parseInt(reportIDInput); // make sure the input is numeric
                if (reportIDInput.length() == 10) { // make sure there are 9 digits
                    isValid = true;
                }
                else {
                    System.out.println("Invalid. Please try again with 10 digits.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Please try again with only numbers.");
            }
        }
        return reportIDInput;
    }

    // make sure input is numeric between 1 and 10
    public String mhi() {
        String mhiInput = null; // user input
        String cancel = "cancel"; // cancel option
        int value = 0; // make sure input is numeric
        boolean isValid = false; // for while loop when input is not numeric oor not between 1 and 10

        while(!isValid) {
            mhiInput = this.userInput.nextLine();
            mhiInput = mhiInput.toLowerCase();
            if (mhiInput.equals(cancel)) {
                return cancel;
            }
            try {
                value = Integer.parseInt(mhiInput); // make sure the input is numeric
                if (value >= 1 && value <=10) { // make sure mhi input is valid
                    isValid = true;
                }
                else {
                    System.out.println("Invalid. Please try again between 1 and 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Please try again between 1 and 10.");
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
        boolean isValid = false; // for while loop when input is not numeric oor not between 1900 and 2100
        while(!isValid) {
            identityInput = userInput.nextLine();
            identityInput = identityInput.toLowerCase();
            if (identityInput.equals(cancel)) {
                return cancel;
            }
            if (identityInput.equals(yes) || identityInput.equals(no)) {
                isValid = true;
            }
            else {
                System.out.println("Invalid. Please enter 'y' or 'n'");
            }
        }
        return identityInput;
    }
}
