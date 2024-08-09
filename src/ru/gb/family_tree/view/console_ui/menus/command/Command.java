package ru.gb.family_tree.view.console_ui.menus.command;

import ru.gb.family_tree.view.console_ui.ConsoleUi;

public abstract class Command {
    private String description = "";
    private ConsoleUi consoleUi;

    public Command(String description, ConsoleUi consoleUi) {
        this.consoleUi = consoleUi;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ConsoleUi getConsoleUi() {
        return consoleUi;
    }

    public abstract void execute();
}
