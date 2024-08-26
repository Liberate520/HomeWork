import model.family_tree.FamilyTreeService;
import model.family_tree.FamilyTreeServiceInterface;
import model.writers.FileHandler;
import model.writers.ObjectReader;
import model.writers.ObjectWriter;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

public class Main {
        public static void main(String[] args) {
                ObjectWriter writer = new FileHandler();
                ObjectReader reader = new FileHandler();
                FamilyTreeServiceInterface service = new FamilyTreeService(writer, reader);
                Presenter presenter = new Presenter(service);
                View view = new ConsoleUI(presenter);
                presenter.setView(view);
                view.start();
        }
}