package view.commands;

import view.ConsoleUI;

public class setParents extends Commands{
    public setParents(ConsoleUI consoleUI) {
        super("Определить родственные связи в древе", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setParents();
    }
}
