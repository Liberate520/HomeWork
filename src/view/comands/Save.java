package view.comands;

import view.ConsoleUI;

public class Save extends Command{


    public Save(ConsoleUI consoleUI) {
        super(consoleUI, "Сохранить семейное дерево");
    }

    @Override
    public void execute() {
        getConsoleUI().Save();
    }
}
