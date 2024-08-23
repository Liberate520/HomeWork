package view.commands;

import view.ConsoleUI;

public class AddChildById extends Command{

    public AddChildById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка по ID к родителю, если оба есть в семейном древе";
    }

    public void execute(){
        consoleUI.addChildById();
    }
}
