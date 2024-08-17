package view.commands;

import presenter.Presenter;
import view.Command;

public class SortByNameCommand implements Command {
    private Presenter presenter;

    public SortByNameCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByName();
    }
}

