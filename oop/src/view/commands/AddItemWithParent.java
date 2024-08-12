package view.commands;

import view.ConsoleUI;

public class AddItemWithParent extends Command{

    public AddItemWithParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить живого человека с родителями в семейное древо\n" +
                "Родители уже должны быть добавлены ранее";
    }

    public void execute(){
        consoleUI.addItemWithParent();
    }
}