package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class EstablishMarriage extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public EstablishMarriage(ConsoleUI consoleUI) {
        super("Зарегистрировать брак", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().establishMarriage();
    }
}
