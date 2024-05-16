package view.command;

import view.ConsoleUI;

public class AddElement extends Command{

    public AddElement(ConsoleUI consoleUI){
        super("Добавить элемент древа.", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().addNewSubjectToTree();
    }
}
