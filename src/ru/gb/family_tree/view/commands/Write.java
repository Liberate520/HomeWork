package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class Write extends Command {
    public Write(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить информацию по дереву в файл";
    }

    @Override
    public void execute() {
        consoleUI.write();
    }
}


//-------------------------------------------------------