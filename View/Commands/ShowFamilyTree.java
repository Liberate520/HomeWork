package View.Commands;

import View.ConsoleWork;

public class ShowFamilyTree extends Command {

    public ShowFamilyTree(ConsoleWork consoleWork) {
        super(consoleWork);
        description = "Показать всё семейное дерево";
    }

    @Override
    public void execute() {
        consoleWork.showFamilyTree();
    }
}


