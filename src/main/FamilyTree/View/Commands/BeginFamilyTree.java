package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

public class BeginFamilyTree extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public BeginFamilyTree(ConsoleUI consoleUI) {
        super("Начать собирать фамильное дерево:", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().beginTree();

    }



}
