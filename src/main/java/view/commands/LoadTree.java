package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class LoadTree extends Command {

    public LoadTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Загрузить дерево из файла.";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.LoadTree();
    }
}
