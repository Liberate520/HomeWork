package view.UIs.commands;

import view.UIs.console.ConsoleUI;

public class GetChildrenCom extends Command{
    public GetChildrenCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getChildren();
    }
}