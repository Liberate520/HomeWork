package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class Finish extends Command {


    public Finish(ConsoleUI consoleUI) {
        super(consoleUI, "Завершить работу");
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }

}
