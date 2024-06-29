package view.commands;

import view.ConsoleUI;

public class GetFamilyTreeInfo extends Command {
    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Посмотреть дерево";
    }

    public void execute(){
        consoleUI.getFamilyTreeInfo();
    }
}
