package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class AddRelative extends Command{

    public AddRelative(ConsoleUI consoleUI) {
        super("добавление родственника", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addRelative();
    }


}
