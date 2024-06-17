//package view.commands;
//
//import view.ConsoleUI;
//
//public class SortByName extends Command {
//    public SortByName(ConsoleUI consoleUI) {
//        super(consoleUI);
//        description = "Отсортировать по имени";
//    }
//
//    @Override
//    public void execute() {
//        consoleUI.sortByName();
//    }
//}
package view.commands;

import view.ConsoleUI;

public class SortByName implements Command {
    private ConsoleUI consoleUI;

    public SortByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
