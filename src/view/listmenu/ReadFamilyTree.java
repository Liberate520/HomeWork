package view.listmenu;

import view.ConsoleUI;

import java.io.IOException;

public class ReadFamilyTree extends Command {
    public ReadFamilyTree(ConsoleUI consoleUI) {
        super("Загрузить данные", consoleUI);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsoleUI().displayFamilyTree();
    }
}
