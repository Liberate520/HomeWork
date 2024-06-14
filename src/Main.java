import view.UserInterface;
import Presenter.FamilyTreePresenter;
import model.FamilyTree;
import model.Node;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра UserInterface
        UserInterface ui = new UserInterface();

        // Создание экземпляра FamilyTree
        FamilyTree<Node> familyTree = new FamilyTree<>();

        // Создание экземпляра FamilyTreePresenter
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, ui);

        // Передача presenter в UserInterface
        ui.setPresenter(presenter);

        // Запуск интерфейса пользователя
        ui.start();
    }
}