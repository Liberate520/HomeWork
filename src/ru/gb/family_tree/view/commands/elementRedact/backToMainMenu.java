package ru.gb.family_tree.view.commands.elementRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class backToMainMenu extends Command {


    public backToMainMenu(ConsoleUI consoleUI) {
        super("Назад", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().clearConsole();
        getConsoleUI().choiseMainMenu();
    }
}