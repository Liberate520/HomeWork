package Family_tree.View;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Presenter.Presenter;

public abstract class View<T extends Endothermal> {
    public abstract void start();

    public abstract Presenter<T> getPresenter();

}
