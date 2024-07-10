package view.UIs.commands;

import view.UIs.ConsoleUI;
import view.View;

public class PrintTreeCom extends Command{
    public PrintTreeCom(String name, ConsoleUI view) {
        super(name, view);
    }

    @Override
    public void exec() {
        view.printTree();
    }
}
