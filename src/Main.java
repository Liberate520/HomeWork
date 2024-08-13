import Model.Service;
import Model.Formating.Writer.FileHandler;
import Model.Formating.Writer.Writer;
import Presenter.Presenter;
import View.*;

public class Main {
    public static void main(String[] args) {
        Writer writer = new FileHandler();

        View view = new ConsoleUI();

        Service service = new Service(writer);

        new Presenter(view, service);

        view.mainLoop();
    }
}
