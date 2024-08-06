package view.commands;

import view.ConsoleUI;

public class LoadFamilyTreeData extends Command {

    public LoadFamilyTreeData(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить данные";
    }

    @Override
    public void execute() {
        try {
            consoleUI.loadFamilyTreeData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}