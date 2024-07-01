package ru.gb.family_tree.view.commands.treeRedact;
import ru.gb.family_tree.view.ConsoleUI;


public class back extends Command {


    public back(ConsoleUI consoleUI) {
        super("Назад", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().choiseMainMenu();
    }
}