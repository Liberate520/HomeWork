import view.ConsoleUI;
import presenter.Presenter;
import service.FamilyTreeServiceImpl;

public class Main {
    public static void main(String[] args) {
        FamilyTreeServiceImpl familyTreeService = new FamilyTreeServiceImpl();
        Presenter presenter = new Presenter(familyTreeService, new ConsoleUI());
        ConsoleUI ui = new ConsoleUI(presenter);
        ui.start();
    }
}

