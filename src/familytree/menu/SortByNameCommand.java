package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

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