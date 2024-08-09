package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class ReadTree extends Command{
    public ReadTree(ConsoleUI consoleUI) {
        super("Открыть дерево", consoleUI);
    }
    @Override
    public void execute(){
        consoleUI.readTree();
    }
}