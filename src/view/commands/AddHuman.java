package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI, "�������� ������������");
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
