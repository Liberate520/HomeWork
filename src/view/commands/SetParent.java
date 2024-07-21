package view.commands;

import view.ConsoleUI;

public class SetParent extends Command{
    public SetParent(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setParent();
    }
}
