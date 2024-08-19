package homeWork.View.Commands;

import homeWork.View.ConsoleUI;

public class GetFamilyTree extends Command{

    public GetFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить инвормацию о семейном древе";
    }

    public void execute(){
        consoleUI.getFamilyTree();
    }
}
