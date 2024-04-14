import model.writer.FileHandler;
import view.ConsoleUI;

public class Main {
    public static void main(String[] args)  {
        ConsoleUI ui = new ConsoleUI(new FileHandler());
        ui.start();
    }
}
