package view.commands;

import view.ConsoleUI;


public class SetSpouse extends Command {

    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супруга(у)";
    }

    @Override
    public void execute() {
        consoleUI.setSpouse();
    }
}