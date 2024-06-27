package view.comands;

import view.ConsoleUI;

public class AddParentOrChild extends Command{
    public AddParentOrChild(ConsoleUI consoleUI) {
        super(consoleUI, "Указать родителя/ребёнка");
    }

    @Override
    public void execute() {
        getConsoleUI().AddParentOrChild();
    }
}
