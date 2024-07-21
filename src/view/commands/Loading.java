package view.commands;

import view.ConsoleUI;

public class Loading extends Command{
    public Loading(ConsoleUI consoleUI) {
        super("Загрузить семейное дерево", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().loading();
    }
}
