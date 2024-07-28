package view.commands;

import view.ConsoleUI;

public class StopProgram extends Commands {

    public StopProgram(ConsoleUI consoleUI) {
        super("Завершить работу с семейным древом.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().stopProgram();
    }
}
