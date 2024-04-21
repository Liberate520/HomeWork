package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

public class PaternityNewParent extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public PaternityNewParent(ConsoleUI consoleUI) {
        super("Pебенок есть в дереве, родителя нужно добавить", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().paternityNewParent();
    }
}
