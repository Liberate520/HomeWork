package ru.gb.family_tree.view.commands.elementRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class addNewInfoAboutElement extends Command{
    public addNewInfoAboutElement(ConsoleUI consoleUI) {
        super("Дополнить элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addNewInfoAboutElement();
    }
}