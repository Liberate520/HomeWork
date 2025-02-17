package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class SetMother extends Command{
    public SetMother(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Установить мать";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {consoleUI.setMother();}
}
