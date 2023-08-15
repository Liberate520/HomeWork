package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }

    @Override
    public void execute(String path) {
        super.getConsoleUI().Finish();
    }

    @Override
    public void execute() {

    }
}
