package ru.gb.family_tree.view.commands.elementRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class createNewElement extends Command {


    public createNewElement(ConsoleUI consoleUI) {
        super("Создать новый элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().createNewElement();
        getConsoleUI().choiseRedactElement();

    }
}
