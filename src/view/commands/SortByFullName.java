package view.commands;

import view.ConsoleUI;

public class SortByFullName extends Command {
    public SortByFullName(ConsoleUI consoleUI) {
        super(consoleUI,"������������� �������� ������ �� ���");
    }

    public void execute(){
        consoleUI.sortByFullName();
    }
}
