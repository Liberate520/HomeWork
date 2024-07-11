package ru.gb.family_tree;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.TreeNodeImpl;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        FamilyTree<TreeNodeImpl> familyTree = new FamilyTree<>();
        FamilyTreeService<TreeNodeImpl> familyTreeService = new FamilyTreeService<>(familyTree);
        ConsoleUI<TreeNodeImpl> consoleUI = new ConsoleUI<>(familyTreeService);
        Presenter<TreeNodeImpl> presenter = new Presenter<>(familyTreeService, consoleUI);

        presenter.start();
    }
}
