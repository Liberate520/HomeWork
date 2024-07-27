package view.listmenu;

import view.ConsoleUI;

import java.io.IOException;

public class SaveFamilyTree extends Command {
    public SaveFamilyTree(ConsoleUI consoleUI) {
        super("Сохранить данные", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().saveFamilyTree();
    }
}
