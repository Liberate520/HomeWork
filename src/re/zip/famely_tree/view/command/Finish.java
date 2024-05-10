package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}