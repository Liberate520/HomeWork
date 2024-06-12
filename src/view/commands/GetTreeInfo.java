package view.commands;

//package view.commands;

import view.ConsoleUI;

public class GetTreeInfo extends Command {
    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить информацию о дереве";
    }

    @Override
    public void execute() {
        consoleUI.getTreeInfo();
    }
}
