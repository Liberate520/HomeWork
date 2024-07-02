package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class GetRelativeByNameSurname extends Command{

    public GetRelativeByNameSurname(ConsoleUI consoleUI) {
        super("поиск родственника по имени и фамилии", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getByNameSurname();
    }
}
