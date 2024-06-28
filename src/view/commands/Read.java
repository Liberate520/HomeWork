package view.commands;

import view.ConsoleUI;


public class Read extends Command {
    public Read(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить дерево";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}