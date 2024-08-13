package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

public class SortByAgeCommand implements Command {
    private FamilyTreePresenter presenter;

    public SortByAgeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByAge();
    }
}