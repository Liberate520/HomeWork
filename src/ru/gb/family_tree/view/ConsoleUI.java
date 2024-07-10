package ru.gb.family_tree.view;

import ru.gb.family_tree.model.family_tree.TreeNode;
import ru.gb.family_tree.model.family_tree.TreeNodeImpl;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.commands.*;

import java.util.HashMap;
import java.util.Map;

public class ConsoleUI<E extends TreeNode<E>> {
    private final FamilyTreeService<E> familyTreeService;
    private final View view;
    private final Map<Integer, Command> commands;

    public ConsoleUI(FamilyTreeService<E> familyTreeService) {
        this.familyTreeService = familyTreeService;
        this.view = new View();
        this.commands = new HashMap<>();

        initializeCommands();
    }

    private void initializeCommands() {
        commands.put(1, new AddHumanCommand((FamilyTreeService<TreeNodeImpl>) familyTreeService, view));
        commands.put(2, new RemoveHumanCommand<>(familyTreeService, view));
        commands.put(3, new SortByNameCommand<>(familyTreeService, view));
        commands.put(4, new SortByBirthDateCommand<>(familyTreeService, view));
        commands.put(5, new PrintFamilyTreeInfoCommand<>(familyTreeService, view));
        commands.put(6, new AddParentCommand((FamilyTreeService<TreeNodeImpl>) familyTreeService, view));
        commands.put(7, new AddChildCommand((FamilyTreeService<TreeNodeImpl>) familyTreeService, view));
    }

    public void start() {
        while (true) {
            int choice = view.displayMenuAndGetChoice();
            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else if (choice == 0) {
                exit();
                return;
            } else {
                view.displayMessage("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private void exit() {
        view.displayMessage("Выход из программы.");
        view.close();
    }

    public View getView() {
        return view;
    }

    public Map<Integer, Command> getCommands() {
        return commands;
    }
}
