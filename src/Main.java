import view.ConsoleUI;
import view.View;
import java.io.IOException;

public class Main {
    final static String fileName = "src/file.txt";

    public static void main(String[] args) throws IOException {
        View view = new ConsoleUI();
        view.start();
    }
}
