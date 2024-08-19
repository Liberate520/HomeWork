package familytree.main;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.ui.UserInterface;

import familytree.presenter.FamilyTreePresenter;
import familytree.ui.ConsoleUserInterface;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        UserInterface view = new ConsoleUserInterface();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);

        while (true) {
            presenter.handleUserInput();
        }
    }
}