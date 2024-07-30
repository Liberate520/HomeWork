import Model.Writer.FileHandler;
import Model.Writer.Writer;
import Presenter.Leader;
import View.*;

public class Main {
    public static void main(String[] args) {
        Writer writer = new FileHandler();

        View view = new ConsoleUI();

        new Leader(view, writer);

        view.mainLoop();
    }
}
