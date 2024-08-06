package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class SortByNameAction implements MenuActions {
    @Override
    public void execute(Presenter presenter) {
        System.out.println("Отсортированный по имени список: \n");
        presenter.sortByName();
    }
}
