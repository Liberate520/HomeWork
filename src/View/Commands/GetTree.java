package View.Commands;

import View.ConsoleUI;

public class GetTree extends Command {
    public GetTree(ConsoleUI consoleUI) {
        super("Посмотреть дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getTree();
    }
}
