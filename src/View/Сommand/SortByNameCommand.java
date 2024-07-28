package View.Сommand;

import Presenter.FamilyTreePresenter;

public class SortByNameCommand implements Command {
    private final FamilyTreePresenter presenter;

    public SortByNameCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.onSortByName();
    }
}
