import view.ConsoleUI;
import view.View;
import model.writer.FileHandler;

public class Main {
    public static void main(String[] args) {

        ConsoleUI test = new ConsoleUI();
        test.setWritable(new FileHandler());
        test.start();
    }
}