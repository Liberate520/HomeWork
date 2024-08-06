package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class FinishAction implements MenuActions {

    @Override
    public void execute(Presenter presenter) {
        System.out.println("Работа завершена.");
        System.exit(0);
    }
}
