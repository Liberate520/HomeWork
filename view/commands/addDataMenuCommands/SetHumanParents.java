package view.commands.addDataMenuCommands;

import view.ConsoleUI;
import view.commands.Command;

public class SetHumanParents extends Command {

    public SetHumanParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создание связи родители-ребенок";
    }

    @Override
    public void execute() {
        consoleUI.setHumanParents();
    }

}
