package familytree;

import familytree.presenter.FamilyTreePresenter;
import familytree.service.FamilyTreeServiceImpl;
import familytree.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        FamilyTreeServiceImpl service = new FamilyTreeServiceImpl();
        ConsoleView view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);
        presenter.run();
    }
}