package view.commands;

import view.ConsoleUI;

public class SetChildren extends Command{
    public SetChildren(ConsoleUI consoleUI) {
        super("Добавить детей", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setChildren();
    }
}
