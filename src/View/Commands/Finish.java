package View.Commands;

import View.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу с семейным деревом";
    }

    public void execute() {
        consoleUI.finishWork();
    }
}
