package ui.optionConsole;

import ui.Console;

public class GetTree extends Option {

    public GetTree(Console console) {
        super(console);
        setDescription("������� �������� ������.");
    }

    @Override
    public void execute() {
        super.getConsole().getTree();
    }
}
