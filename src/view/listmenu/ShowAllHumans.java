package view.listmenu;

import view.ConsoleUI;

public class ShowAllHumans extends Command {
    public ShowAllHumans(ConsoleUI consoleUI) {
        super("Показать всех людей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showAllPeople();
    }
}