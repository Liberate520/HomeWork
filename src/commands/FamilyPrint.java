package commands;

import Viev.Console;

public class FamilyPrint extends Command
{
    public FamilyPrint(Console console)
    {
        super(console);
    }

    @Override
    public String description()
    {
        return "������ ��������� �����.";
    }

    @Override
    public void execute()
    {
        getConsole().familyPrint();
    }
}