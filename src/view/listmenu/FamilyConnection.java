package view.listmenu;

import view.ConsoleUI;

import java.io.IOException;

public class FamilyConnection extends Command {
    public FamilyConnection(ConsoleUI consoleUI) {
        super("Установить родственные связи между людьми", consoleUI);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsoleUI().setFamilyRelations();
    }
}
