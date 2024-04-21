package FamilyTree.View.Commands;



import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class Finish extends Commands {
    private String description;
    private ConsoleUI consoleUI;

    public Finish( ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().finish();
    }
}
