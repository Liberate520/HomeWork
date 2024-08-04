package view.UIs.commands;

import view.UIs.ConsoleUI;
import view.View;

public class GetHumanCom extends Command{
    public GetHumanCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.getById();
    }
}