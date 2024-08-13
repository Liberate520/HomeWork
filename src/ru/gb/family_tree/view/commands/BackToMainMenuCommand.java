package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class BackToMainMenuCommand extends Command {

    public BackToMainMenuCommand(ConsoleUI consoleUI) {
        super("Вернуться в главное меню", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().backToMainMenu();
    }
}