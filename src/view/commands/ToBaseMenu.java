package view.commands;

import view.ConsoleUi;

public class ToBaseMenu extends Command {

    public ToBaseMenu(ConsoleUi consoleUi) {
        super("Вернуться в основное меню", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().toBaseMenu();
    }
}
