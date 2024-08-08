package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI, "Закончить работу");
    }

    @Override
    public void execute() {
        getConsoleUI().finish();

    }
}
