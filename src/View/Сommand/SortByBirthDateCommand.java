package View.Сommand;

import Presenter.FamilyTreePresenter;

public class SortByBirthDateCommand implements Command {
    private final FamilyTreePresenter presenter;

    public SortByBirthDateCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.onSortByBirthDate();
    }
}
