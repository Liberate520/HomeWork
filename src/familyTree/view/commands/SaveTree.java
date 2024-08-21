package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class SaveTree extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить программу в \"src/familyTree/file.txt\"", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}