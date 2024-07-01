package ru.gb.family_tree.view.commands.elementRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class deleteElement extends Command{
    public deleteElement(ConsoleUI consoleUI) {
        super("Удалить элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().deleteElement();
    }
}