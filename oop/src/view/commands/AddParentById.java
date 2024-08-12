package view.commands;

import view.ConsoleUI;

public class AddParentById extends Command{

    public AddParentById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителя по ID к ребенку, если оба есть в семейном древе";
    }

    public void execute(){
        consoleUI.addParentById();
    }
}