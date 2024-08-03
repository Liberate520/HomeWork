package view.commands.addDataMenuCommands;

import view.ConsoleUI;
import view.commands.Command;

public class SetHumanSpouse extends Command {

    public SetHumanSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавление связи муж-жена";
    }

    @Override
    public void execute() {
        consoleUI.setHumanSpouse();
    }
}