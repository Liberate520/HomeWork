package view.allcommands;

import view.ConsoleUI;

public class PrintLoadedTree extends Command {

    public PrintLoadedTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description="Загрузить древо из файла и вывести на экран";
    }

    @Override
    public void execute() {
        consoleUI.printLoadedTree();
    }

}
