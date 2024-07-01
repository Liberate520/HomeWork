package ru.gb.family_tree.view.commands.mainMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class workWithElement extends Command {
    public workWithElement(ConsoleUI consoleUI) {
        super("Работа с элементами", consoleUI);
    }

    @Override
    public void execute(){

        getConsoleUI().clearConsole();
        getConsoleUI().choiseRedactElement();
    }
}