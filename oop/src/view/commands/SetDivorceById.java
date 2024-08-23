package view.commands;

import view.ConsoleUI;

public class SetDivorceById extends Command{

    public SetDivorceById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Развестись по ID если оба человека в семейном древе";
    }

    public void execute(){
        consoleUI.setDivorceById();
    }
}
