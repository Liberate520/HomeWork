package view.commands;

import view.ConsoleUI;

public class GetHumanList extends Command {
    public GetHumanList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort by Day of Birth";
    }

    public void execute(){
        consoleUI.getHumanList();
    }
}