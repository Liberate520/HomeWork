package view.commands.get;

import view.ConsoleUI;
import view.commands.Command;

public class GetHumansListInfo extends Command {
    public GetHumansListInfo(ConsoleUI consoleUI) {
        super("Получить список людей", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getHumansListInfo();
    }
}