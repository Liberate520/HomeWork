package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

public class MarriageNewPartner extends Commands {
    private String description;
    private ConsoleUI consoleUI;

    public MarriageNewPartner(ConsoleUI consoleUI) {
        super(" В дереве есть только один партнер ->", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().marriageNewPartner();
    }
}
