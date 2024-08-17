package view.commands;

import presenter.Presenter;
import view.Command;

public class SortByBirthDateCommand implements Command {
    private Presenter presenter;

    public SortByBirthDateCommand(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByBirthDate();
    }
}

