package view.commands;

import view.ConsoleUI;

public class GetByName extends Command{

    public GetByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти человека по имени";
    }

    public void execute(){
        consoleUI.getByName();
    }
}
