package view.UIs.commands;

import view.UIs.ConsoleUI;
import view.View;

public class GetSiblingsCom extends Command{
    public GetSiblingsCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getSiblings();
    }
}
