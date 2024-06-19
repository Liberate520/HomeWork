package view.commands;

import view.ConsoleUI;

public class GetHumanListInfo extends  Command{
    public GetHumanListInfo(ConsoleUI consoleUI){
        super("Вывести весь список", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().getHumanListInfo();
    }
}
