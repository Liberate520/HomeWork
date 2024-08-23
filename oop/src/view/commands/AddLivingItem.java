package view.commands;

import view.ConsoleUI;

public class AddLivingItem extends Command{

    public AddLivingItem(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить живого человека без родителей в семейное древо";
    }

    public void execute(){
        consoleUI.addLivingItem();
    }
}

