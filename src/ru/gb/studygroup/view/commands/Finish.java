package ru.gb.studygroup.view.commands;

import ru.gb.studygroup.view.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super("Завершение работы", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }

}
