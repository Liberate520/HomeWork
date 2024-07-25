package view.commands.basemenu;

import view.ConsoleUi;
import view.commands.Command;

import java.io.IOException;

public class WriteTree extends Command {
    public WriteTree(ConsoleUi consoleUi) {
        super("Сохранить дерево в файл", consoleUi);
    }

    @Override
    public void execute() {
        try {
            getConsoleUi().writeTree();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}