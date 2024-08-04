package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){

        consoleUI.finish();
    }
}
