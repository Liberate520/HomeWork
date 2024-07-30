import service.*;
import view.ConsoleUI;
import presenter.Presenter;
import presenter.PresenterImpl;

public class Main {
    public static void main(String[] args) {
        FileSaver fileSaver = new FileHandler();
        FileLoader fileLoader = new FileHandler();
        FamilyTreeManagementService managementService = new FamilyTreeServiceImpl(fileSaver, fileLoader);
        FamilyTreePersistenceService persistenceService = (FamilyTreePersistenceService) managementService;
        ConsoleUI ui = new ConsoleUI();
        Presenter presenter = new PresenterImpl(managementService, persistenceService, ui);
        ui.setPresenter(presenter);
        ui.start();
    }
}
