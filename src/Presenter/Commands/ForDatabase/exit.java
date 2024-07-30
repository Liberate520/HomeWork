package Presenter.Commands.ForDatabase;

import Presenter.Commands.Command;
import View.View;

public class exit extends Command {
    private final View View;

    public exit(View view){
        super("exit", "Выход из программы");
        this.View = view;
    }

    @Override
    public void execute() {
        this.View.exit();
    }
}
