package view.commands;

import view.ConsoleUI;

public class GetHumanList extends Command{
    public GetHumanList(ConsoleUI consoleUI) {
        super(consoleUI, "�������� ������ ����� ��������� ������");
    }

    @Override
    public void execute() {
        consoleUI.getHumanList();
    }
}