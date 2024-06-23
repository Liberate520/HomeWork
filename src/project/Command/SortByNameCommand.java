package project.Command;

import project.Presenter.FamilyTreePresenter;

public class SortByNameCommand implements Command {
    private FamilyTreePresenter presenter;

    public SortByNameCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByName();
    }
}

