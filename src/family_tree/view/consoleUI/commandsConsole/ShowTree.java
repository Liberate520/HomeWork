package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class ShowTree extends Command {

    public ShowTree(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Показать дерево";
    }

    @Override
    public void execute() {
        consoleUI.ShowTree();
    }
}
