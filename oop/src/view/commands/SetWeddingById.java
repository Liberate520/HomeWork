package view.commands;

import view.ConsoleUI;

public class SetWeddingById extends Command{

    public SetWeddingById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Жениться по ID, если оба будущих супруга в древе";
    }

    public void execute(){
        consoleUI.setWeddingById();
    }
}
