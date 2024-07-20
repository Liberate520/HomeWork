package Presenter.DatabasePresenter.Commands;

import Presenter.BaseClasses.Command;
import View.Interface.DatabaseView;

public class exit extends Command {
    private final DatabaseView view;

    public exit(DatabaseView view){
        super("exit", "Выход из программы");

        this.view = view;
    }

    @Override
    public void execute() {
        this.view.exit();
    }
}
