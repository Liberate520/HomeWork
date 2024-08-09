package familytree;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.presenter.FamilyTreePresenter;
import familytree.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        ConsoleView view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);
        presenter.run();
    }
}
