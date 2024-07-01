package view.command;

import view.ConsoleUI;

public class Print extends Command {

    public Print(ConsoleUI consoleUI) {
        super("Распечатать семейно дерево ->", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().choicingPrint();
    }
}
