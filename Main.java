import model.Model;
import model.Service.Service;
import model.Writer.FileHandler;
import Presenter.Presenter;
import View.Menu;
import View.View;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        Service service = new Service(fileHandler); 
        Model model = new Model(service); 
        Menu menu = new Menu();
        View view = new View(model, menu);
        Presenter presenter = new Presenter(model, view, menu);
        presenter.start();
    }
}