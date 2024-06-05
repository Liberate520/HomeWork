package view.commands;

import view.ConsoleUI;

public class ShowTree extends Command {
    public ShowTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Показать дерево";
    }

    @Override
    public void execute() {consoleUI.showTree();}
}
