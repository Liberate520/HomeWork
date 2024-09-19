package ru.gb.family_tree.model.app;

import ru.gb.family_tree.model.FT.FamilyTree;
import ru.gb.family_tree.model.FT.FamilyTreeInterface;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.builder.HumanBuilderInterface;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

public class AppFactory {
    public static View createView() {

        FamilyTreeInterface<Human> familyTree = new FamilyTree<>();
        HumanBuilderInterface humanBuilder = new HumanBuilder();
        Service service = new Service(familyTree, humanBuilder, "familyTree.txt", "humanBuilder.txt");

        ConsoleUI consoleUI = new ConsoleUI(null);

        Presenter presenter = new Presenter(consoleUI, service);

        consoleUI.setPresenter(presenter);

        return consoleUI;
    }
}
