package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class Download implements MenuActions{
    @Override
    public void execute(Presenter presenter) {
        presenter.read();
        System.out.println("Сохраненное семейное дерево:");
        presenter.humansInfo();
    }
}
