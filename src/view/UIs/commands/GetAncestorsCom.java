package view.UIs.commands;

import view.UIs.ConsoleUI;
import view.View;

public class GetAncestorsCom extends Command{
    public GetAncestorsCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getAncestors();
    }
}
