package ru.gb.family_tree.view.commands;

public class GetHumanListInfo extends Command {

    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Получить список людей.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();
    }
}
