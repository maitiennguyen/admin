import java.util.Scanner;
import java.util.InputMismatchException;

public class InputHandler {
    private Scanner scanner;
    private boolean chosen;

    public InputHandler() {
        scanner = new Scanner(System.in);
        chosen = false;
    }

    public void handleInput() {
        while (!chosen) {
            try {
                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        // create a Statistics object and call its method
                        Statistics stats = new Statistics();
                        stats.calculate();
                        chosen = true;
                        break;
                    case 2:
                        // create a MoreInformation object and call its method
                        MoreInformation info = new MoreInformation();
                        info.displayInfo();
                        chosen = true;
                        break;
                    case 3:
                        // create a FileReport object and call its method
                        FileReport report = new FileReport();
                        report.createReport();
                        chosen = true;
                        break;
                    case 4:
                        // create an AccessReport object and call its method
                        AccessReport access = new AccessReport();
                        access.showReport();
                        chosen = true;
                        break;
                    default:
                        System.out.println("Invalid input. Try again!");
                        break;
                }
            } catch (InputMismatchException e) {
                // Discard invalid input
                scanner.nextLine();

                // Prompt user to try again
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
        }
    }
}
