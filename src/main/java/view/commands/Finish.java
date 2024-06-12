package view.commands;

import view.ConsoleUI;
import view.Message;

import java.io.IOException;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = Message.THEEND.getMessage();
    }


    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.finish();

    }
}
