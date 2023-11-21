package familyTree.View.Commands;

import familyTree.View.ConsoleUI;

public class SaveTreeToFile extends Command{
    public SaveTreeToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить дерево в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
    }
}
