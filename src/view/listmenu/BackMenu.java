package view.listmenu;

import view.ConsoleUI;

public class BackMenu extends Command {
    public BackMenu(ConsoleUI consoleUI) {
        super("Назад", consoleUI);
    }

    @Override
    public void execute() {
        return;
    }
}
