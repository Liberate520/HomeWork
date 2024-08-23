package view.commands;

import view.ConsoleUI;

public class GetParentById extends Command{

    public GetParentById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти родителей человека по ID";
    }

    public void execute(){
        consoleUI.getParentById();
    }
}