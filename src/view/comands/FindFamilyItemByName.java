package view.comands;

import view.ConsoleUI;

public class FindFamilyItemByName extends Command{
    public FindFamilyItemByName(ConsoleUI consoleUI) {
        super(consoleUI, "Найти члена семьи по имени");
    }

    @Override
    public void execute() {
        getConsoleUI().findFamilyItemByName();
    }
}
