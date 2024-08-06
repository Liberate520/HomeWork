package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class SortByNameAction implements MenuActions {
    @Override
    public void execute(Presenter presenter) {
        presenter.sortByName();
    }
}
