package view.commands;

import view.ConsoleUI;

public class AddDeathItem extends Command{

    public AddDeathItem(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить умершего человека без родителей в семейное древо";
    }

    public void execute(){
        consoleUI.addDeathItem();
    }
}
