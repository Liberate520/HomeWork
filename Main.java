import Presenter.Presenter;
import View.ConsoleWork;

public class Main {
    public static void main(String[] args) {
    
        ConsoleWork consoleWork = new ConsoleWork(null);
        Presenter presenter = new Presenter(consoleWork);
        consoleWork.setPresenter(presenter);
        consoleWork.start();
    }
}
