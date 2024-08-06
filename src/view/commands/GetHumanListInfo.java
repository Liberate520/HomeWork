package view.commands;

import view.ConsoleUI;

public class GetHumanListInfo extends Command {

    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Вывести список древа", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();
    }
}
