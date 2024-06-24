package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class GetByOneFamily extends Command{

    public GetByOneFamily(ConsoleUI consoleUI) {
        super("вывод одной семьи по фамилии", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getByOneFamily();
    }
}
