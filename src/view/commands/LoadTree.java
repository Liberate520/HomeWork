package view.commands;

import view.ConsoleUI;

public class LoadTree extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public LoadTree(ConsoleUI consoleUI) {
        super("Загрузить программу из \"src/familyTree/file.txt\"", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadTree();
    }
}