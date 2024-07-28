package View.Сommand;

import Presenter.FamilyTreePresenter;

public class SortByAgeCommand implements Command {
    private final FamilyTreePresenter presenter;

    public SortByAgeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.onSortByAge();
    }
}
