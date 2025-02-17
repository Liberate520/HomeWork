package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class SetFather extends Command{
    public SetFather(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Установить отца";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {consoleUI.setFather();}
}
