import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args)
    {
        homeGUI test1 = new homeGUI();
        boolean running = true;

        while (running) {
            printDisplay display = new printDisplay();
            display.printOptions();

            InputHandler inputHandler = new InputHandler();
            running = inputHandler.handleInput();
        }
    }
}