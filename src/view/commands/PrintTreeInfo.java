package view.commands;

import model.human.Human;
import view.ConsoleUi;

public class PrintTreeInfo extends Command{

    public PrintTreeInfo(ConsoleUi consoleUi) {
        super("Вывести дерево на экран", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().printTree();
    }
}
