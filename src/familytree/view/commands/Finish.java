package familytree.view.commands;

import familytree.view.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute() {
        consoleUI.finish();
    }
}
