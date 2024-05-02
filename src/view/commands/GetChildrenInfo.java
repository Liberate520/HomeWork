package view.commands;

import view.ConsoleUI;

public class GetChildrenInfo extends Command{

    public GetChildrenInfo (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Посмотреть список детей";
    }

    public void execute() {
        consoleUI.getChildrenInfo();
    }
}