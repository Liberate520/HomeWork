package commands;

import Viev.Console;

public class HumanSearch extends Command
{
    public HumanSearch(Console console)
    {
        super(console);
    }

    @Override
    public String description()
    {
        return "����� �������� �� ������. ";
    }

    @Override
    public void execute()
    {
        getConsole().humanSearch();
    }
}