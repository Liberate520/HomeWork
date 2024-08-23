package View.Commands;

import View.ConsoleWork;

public class LoadFamilyTree extends Command {

    public LoadFamilyTree(ConsoleWork consoleWork) {
        super(consoleWork);
        description = "Загрузить семейное дерево";
    }

    public void execute() {
        consoleWork.loadFamilyTree();
    }
}

