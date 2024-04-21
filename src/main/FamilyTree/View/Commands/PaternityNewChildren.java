package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

public class PaternityNewChildren extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public PaternityNewChildren(ConsoleUI consoleUI) {
        super("Родитель есть в дереве, ребенка нужно добавить", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().paternityNewChildren();
    }
}
