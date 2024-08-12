package view.commands;

import view.ConsoleUI;

public class AddChild extends Command{

    public AddChild(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить ребёнка";
    }
    @Override
    public void execute() {
        consoleUI.addChild();
    }
}
