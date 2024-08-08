package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class LoadData extends Command {
    public LoadData(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Загрузить данные из файла";
    }

    @Override
    public void execute() {
        consoleUI.loadData();
    }
}
