package view.commands;

import view.ConsoleUI;
import view.Message;

import java.io.IOException;

public class LoadTree extends Command {

    public LoadTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = Message.LOADTREE.getMessage();
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.loadTree();
    }
}
