package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class Read extends Command {
    public Read(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать информацию по дереву из файла";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}


//-------------------------------------------------------
