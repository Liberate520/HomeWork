package ru.gb.familytree.view.commands;

import ru.gb.familytree.view.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super("Завершение работы", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
