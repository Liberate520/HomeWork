package re.zip.famely_tree.view;

import java.util.Scanner;

public class InputOutput {
    private final Scanner scanner;

    public InputOutput() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void println(String text) {
        System.out.println(text);
    }
}