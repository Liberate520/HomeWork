package ui.optionConsole;

import ui.Console;

public class GetUnitInfo extends Option {

    public GetUnitInfo(Console console) {
        super(console);
        setDescription("���������� �� ����� �����.");
    }

    @Override
    public void execute() {
        super.getConsole().getUnitInfo();
    }
}
