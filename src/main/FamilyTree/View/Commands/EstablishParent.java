package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class EstablishParent extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public EstablishParent(ConsoleUI consoleUI) {
        super("Установить отцовство (родительство)", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().establishPaternity();
    }
}
