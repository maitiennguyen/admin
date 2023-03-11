import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args)
    {
        boolean running = true;

        while (running) {
            printDisplay display = new printDisplay();
            display.printOptions();

            InputHandler inputHandler = new InputHandler();
            running = inputHandler.handleInput();
        }
    }
}