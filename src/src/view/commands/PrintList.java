package src.view.commands;

import src.view.ConsoleUI;

public class PrintList extends Command {

    public PrintList(ConsoleUI consoleUI) {

        super(consoleUI);
        description = "Вывести на экран содержимое древа";

    }

    @Override
    public void execute() {
        consoleUI.printList();
    }

}
