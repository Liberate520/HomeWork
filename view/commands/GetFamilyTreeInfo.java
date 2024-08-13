package view.commands;

import view.ConsoleUI;

public class GetFamilyTreeInfo extends Command {

    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super("Вывести дерево", consoleUI);
    }

    public void execute() {
        getConsoleUI().getFamilyTreeInfo();
    }
}
