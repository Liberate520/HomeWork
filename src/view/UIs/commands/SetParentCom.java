package view.UIs.commands;

import view.UIs.ConsoleUI;
import view.View;

public class SetParentCom extends Command{
    public SetParentCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.setParent();
    }
}
