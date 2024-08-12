package family_tree.view.actions;

import family_tree.presenter.Presenter;

public class Save implements MenuActions{
    @Override
    public void execute(Presenter presenter) {
        presenter.save();
        System.out.println("Файл сохранен");
    }
}
