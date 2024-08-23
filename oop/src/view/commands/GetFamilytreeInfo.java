package view.commands;

import view.ConsoleUI;

public class GetFamilytreeInfo extends Command{

    public GetFamilytreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать все древо";
    }

    public void execute(){
        consoleUI.getFamilyTreeInfo();
    }
}
