package view.commands;

import view.ConsoleUI;

public class GetHumanInfo extends Command {
    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список членов дерева";

    }

    @Override
    public void execute() {
        consoleUI.getHumanListInfo();
    }
}
