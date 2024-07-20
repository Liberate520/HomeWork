package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека в семейное дерево", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addHuman();
    }
}
