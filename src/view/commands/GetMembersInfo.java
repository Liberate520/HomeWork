package view.commands;

import view.ConsoleUI;

public class GetMembersInfo extends Command{

    public GetMembersInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Посмотреть список членов семьи";
    }

    public void execute(){
        consoleUI.getMembersInfo();
    }
}