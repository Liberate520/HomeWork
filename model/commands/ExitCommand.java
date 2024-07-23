package model.commands;

import view.View;

public class ExitCommand implements Command {
    private View view;

    public ExitCommand(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.display("Выход из программы.");
        System.exit(0);
    }
}
