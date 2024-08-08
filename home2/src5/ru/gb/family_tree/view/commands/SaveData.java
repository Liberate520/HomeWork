package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveData extends Command {
    public SaveData(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Сохранить данные в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveData();
    }
}
