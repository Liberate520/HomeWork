package view.commands;

import view.ConsoleUI;
import view.Message;

public class CreateTree extends Command{

    public CreateTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = Message.CREATETREE.getMessage();
    }

    @Override
    public void execute() {
        consoleUI.CreateTree();
    }
}
