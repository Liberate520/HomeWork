package view.commands;

import view.ConsoleUI;

public class GetInfoManForId extends Command{

    public GetInfoManForId(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти информацию о человеке по ID";
    }

    public void execute(){
        consoleUI.getInfoManForId();
    }
}