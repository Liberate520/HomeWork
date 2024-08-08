package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class SortByNameAction implements MenuActions {

    public void execute(Presenter presenter) {
        System.out.println("��������������� �� ����� ������: \n");
        presenter.sortByName();
    }
}
