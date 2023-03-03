package HWGT.ui.commands;

import HWGT.ui.Console;

public class PersonEnvironment extends Command{
    public PersonEnvironment(Console console){super(console);}

    @Override
    public String description(){return "Добавить запись об окружении человека";}

    @Override
    public void execute(){getConsole().personEnvironment();}
}
