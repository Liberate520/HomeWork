package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class DeleteHuman extends Command{

    public DeleteHuman(ConsoleUI consoleUI){
        super("Удалить человека по ID", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().delHuman();
    }
}