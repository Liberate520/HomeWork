package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandFinish extends CommandAbstract {
    public CommandFinish(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Завершить работу";
    }

    public void execute() {
        consoleUI.finish();
    }

}
