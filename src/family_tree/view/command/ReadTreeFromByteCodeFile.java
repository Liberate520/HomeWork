package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class ReadTreeFromByteCodeFile extends  Command{
    public ReadTreeFromByteCodeFile(ConsoleUI consoleUI) {
        super("Read tree from byte code file", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().readTreeFromByteCodeFile();
    }
}
