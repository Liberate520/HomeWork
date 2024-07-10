package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.family_tree.TreeNode;
import ru.gb.family_tree.model.family_tree.TreeNodeImpl;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.view.commands.*;

import java.util.HashMap;
import java.util.Map;

public class Presenter<E extends TreeNode<E>> {
    private final FamilyTreeService<E> familyTreeService;
    private final ConsoleUI<E> consoleUI;

    public Presenter(FamilyTreeService<E> familyTreeService, ConsoleUI<E> consoleUI) {
        this.familyTreeService = familyTreeService;
        this.consoleUI = consoleUI;
        initializeCommands();
    }

    private void initializeCommands() {
        Map<Integer, Command> commands = consoleUI.getCommands();

        // Добавляем обработчики команд
        commands.put(1, new AddHumanCommand((FamilyTreeService<TreeNodeImpl>) familyTreeService, consoleUI.getView()));
        commands.put(2, new RemoveHumanCommand<>(familyTreeService, consoleUI.getView()));
        commands.put(3, new SortByNameCommand<>(familyTreeService, consoleUI.getView()));
        commands.put(4, new SortByBirthDateCommand<>(familyTreeService, consoleUI.getView()));
        commands.put(5, new PrintFamilyTreeInfoCommand<>(familyTreeService, consoleUI.getView()));
    }

    public void start() {
        consoleUI.start();
    }
}
