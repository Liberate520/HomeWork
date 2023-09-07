package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class ReadFile extends Command {
    public ReadFile(ConsoleUI console) {
        super(console);
        description = "Выгрузить данные из файла";
    }

    @Override
    public void execute(){
        consoleUI.readFile();
    }
}