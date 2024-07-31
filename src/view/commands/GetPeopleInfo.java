package view.commands;

import view.ConsoleUI;

public class GetPeopleInfo extends Command{
    public GetPeopleInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить список людей";
    }

    public void execute(){
        consoleUI.getPeopleInfo();
    }
}
