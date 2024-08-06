package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class SortByAgeAction implements MenuActions {
    @Override
    public void execute(Presenter presenter) {
        System.out.println("Отсортированный по возрасту список: \n");
        presenter.sortByAge();
    }
}
