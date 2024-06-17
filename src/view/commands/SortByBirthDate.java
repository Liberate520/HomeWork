//package view.commands;
//
//import view.ConsoleUI;
//
//public class SortByBirthDate extends Command {
//    public SortByBirthDate(ConsoleUI consoleUI) {
//        super(consoleUI);
//        description = "Отсортировать по дате рождения";
//    }
//
//    @Override
//    public void execute() {
//        consoleUI.sortByBirthDate();
//    }
//}
package view.commands;

import view.ConsoleUI;

public class SortByBirthDate implements Command {
    private ConsoleUI consoleUI;

    public SortByBirthDate(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.sortByBirthDate();
    }
}
