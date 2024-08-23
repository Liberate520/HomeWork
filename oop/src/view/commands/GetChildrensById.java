package view.commands;

import view.ConsoleUI;

public class GetChildrensById extends Command{

    public GetChildrensById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти детей человека по ID";
    }

    public void execute(){
        consoleUI.getChildrensById();
    }
}