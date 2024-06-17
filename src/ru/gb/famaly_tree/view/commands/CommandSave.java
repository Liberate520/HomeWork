package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

import java.io.IOException;

public class CommandSave extends CommandAbstract{
    public CommandSave(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Сохранить";
    }

    public void execute() throws IOException {
        consoleUI.save();
    }
}
