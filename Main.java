import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args)
    {
        printDisplay display = new printDisplay();
        display.printOptions();

        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput();
    }
}