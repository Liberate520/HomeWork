package view.UIs.commands;

import view.UIs.ConsoleUI;
import view.View;

public class GetDescendantsCom extends Command{
    public GetDescendantsCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getDescendants();
    }
}
