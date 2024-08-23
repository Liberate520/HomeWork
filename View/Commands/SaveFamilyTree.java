package View.Commands;

import View.ConsoleWork;

public class SaveFamilyTree extends Command {

    public SaveFamilyTree(ConsoleWork consoleWork) {
        super(consoleWork);
        description = "Сохранить семейное дерево";
    }

    public void execute() {
        consoleWork.saveFamilyTree();
        consoleWork.printAnswer("Семейное дерево сохранено.");
    }
}

