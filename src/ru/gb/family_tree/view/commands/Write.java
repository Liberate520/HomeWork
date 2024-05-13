package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class Write extends Command {
    public Write(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить информацию по древу в файл \uD83D\uDCE5";
    }

    @Override
    public void execute() {
        consoleUI.write();
    }
}


//-------------------------------------------------------