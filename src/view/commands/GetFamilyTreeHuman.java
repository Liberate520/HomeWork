package view.commands;

import view.ConsoleUI;

public class GetFamilyTreeHuman extends Command {
    public GetFamilyTreeHuman(ConsoleUI consoleUI) {
        super("Показать семейное дерево человека", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getFamilyTreeHuman();
    }
}
