package View.Commands;

import View.ConsoleUI;

public class Save extends Command{
    public Save( ConsoleUI consoleUI) {
        super("Сохранить", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().Save();
    }
}

