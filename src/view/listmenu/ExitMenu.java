package view.listmenu;

import view.ConsoleUI;

public class ExitMenu extends Command {
    public ExitMenu(ConsoleUI consoleUI) {
        super("Выйти", consoleUI);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}