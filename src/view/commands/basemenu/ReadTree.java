package view.commands.basemenu;

import view.ConsoleUi;
import view.commands.Command;

import java.io.IOException;

public class ReadTree extends Command {
    public ReadTree(ConsoleUi consoleUi) {
        super("Прочитать дерево из файла", consoleUi);
    }

    @Override
    public void execute() {
        try {
            getConsoleUi().readTree();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
