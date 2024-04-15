package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

public class EstablishParent extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public EstablishParent(ConsoleUI consoleUI) {
        super("Установить отцовство (родительство)", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().establishPaternity();
    }
}
