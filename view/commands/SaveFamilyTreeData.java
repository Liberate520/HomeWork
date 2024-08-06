package view.commands;

import view.ConsoleUI;

public class SaveFamilyTreeData extends Command {

    public SaveFamilyTreeData(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить данные";
    }

    @Override
    public void execute() {
        consoleUI.saveFamilyTreeData();
    }

}
