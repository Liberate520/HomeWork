package view.commands;

import view.ConsoleUI;
import view.Message;

import java.io.IOException;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = Message.SSAVETREE.getMessage();
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.saveTree();
    }
}
