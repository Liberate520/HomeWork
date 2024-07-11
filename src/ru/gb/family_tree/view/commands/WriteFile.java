package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class WriteFile extends Commands {

    public WriteFile(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Записать данные в файл";
    }
    @Override
    public void execute() throws IOException {
        consoleUI.writeFile();
    }
}
