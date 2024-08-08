package view.comand;

import view.ConsoleUI;

public class GetTreeInfo extends Command{
    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести семейное дерево";
    }
    public void execute(){
        consoleUI.getTreeInfo();
    }
}
