package commands;


import Viev.Console;

public class AddHuman extends Command
{
    public AddHuman(Console console)
    {
        super(console);
    }

    @Override
    public String description()
    {
        return "���������� �������� � �����. ";
    }

    @Override
    public void execute()
    {
        getConsole().addHumanNew();
    }
}
