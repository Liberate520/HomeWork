package re.zip.famely_tree.view;

import java.util.Scanner;

public class ConsoleInputOutput extends InputOutput {

    private Scanner scanner;

    public ConsoleInputOutput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public void println(String text) {
        System.out.println(text);
    }
}