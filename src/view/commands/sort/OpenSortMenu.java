package view.commands.sort;

import view.ConsoleUI;
import view.commands.Command;

public class OpenSortMenu extends Command {
    public OpenSortMenu(ConsoleUI consoleUI) {
        super("Отсортировать людей по параметру", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().openSortMenu();
    }
}
