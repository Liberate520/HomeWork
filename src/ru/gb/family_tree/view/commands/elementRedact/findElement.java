package ru.gb.family_tree.view.commands.elementRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class findElement extends Command{
    public findElement(ConsoleUI consoleUI) {
        super("Найти элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().clearConsole();
        getConsoleUI().findElement();
    }
}
