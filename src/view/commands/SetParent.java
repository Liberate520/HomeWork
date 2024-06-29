package view.commands;

import view.ConsoleUI;


public class SetParent extends Command {

    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя";
    }

    @Override
    public void execute() {
        consoleUI.setParent();
    }
}
