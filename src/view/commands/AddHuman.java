package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить человека в древо";
    }

    @Override
    public void execute() {consoleUI.addHuman();}
}
