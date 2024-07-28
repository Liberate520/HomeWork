package view.commands;

import view.ConsoleUI;

public class GetHumanListInfo extends Commands {

    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Вывести список людей в семейном древе.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();
    }
}
