package FamilyTree.View.Commands;

import FamilyTree.View.ConsoleUI;

public class PrintTree extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public PrintTree(ConsoleUI consoleUI) {
        super("вывести на экран дерево", consoleUI);

    }

    @Override
    public void execute(){
         super.getConsoleUI().getTree();

    }
}
