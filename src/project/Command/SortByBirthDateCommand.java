package project.Command;

import project.Presenter.FamilyTreePresenter;

public class SortByBirthDateCommand implements Command {
    private FamilyTreePresenter presenter;

    public SortByBirthDateCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByBirthDate();
    }
}

