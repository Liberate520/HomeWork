package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

import java.io.IOException;

public class CommandDownload extends CommandAbstract{
    public CommandDownload(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Загрузить";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.download();
    }
}