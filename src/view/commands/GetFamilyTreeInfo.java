package view.commands;

import view.ConsoleUI;

public class GetFamilyTreeInfo extends Command{

    public GetFamilyTreeInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Показать весь список";
    }
    @Override
    public void execute() {
        consoleUI.getFamilyTreeinfo();
    }
}