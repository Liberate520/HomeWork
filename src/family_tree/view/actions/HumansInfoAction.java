package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class HumansInfoAction implements MenuActions {

    @Override
    public void execute(Presenter presenter) {
        presenter.humansInfo();
    }
}
