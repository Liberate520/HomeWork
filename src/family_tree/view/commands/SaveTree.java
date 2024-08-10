package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить дерево", consoleUI);
    }
    @Override
    public void execute(){
        consoleUI.saveTree();
    }
}
