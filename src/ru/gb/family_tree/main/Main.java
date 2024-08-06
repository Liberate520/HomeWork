package ru.gb.family_tree.main;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.models.Human;
import ru.gb.family_tree.presenter.FamilyTreePresenter;
import ru.gb.family_tree.utils.FileHandler;
import ru.gb.family_tree.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler<Human> fileHandler = new FileHandler<>();
        ConsoleView view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);

        // Пример взаимодействия
        presenter.addMember("Alice", "01-01-1970", "женский");
        presenter.addMember("Eugen", "21-08-1965", "мужской");
        presenter.addMember("Bob", "01-01-2000", "мужской");
        presenter.addMember("Charlie", "01-01-2005", "мужской");

        presenter.setSpouse(1, 2);
        presenter.setParent(3, 1);
        presenter.setParent(3, 2);
        presenter.setParent(4, 1);
        presenter.setParent(4, 2);

        presenter.showAllMembers();
    }
}
