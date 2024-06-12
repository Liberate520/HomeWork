package Family_tree.View;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Presenter.Presenter;

public abstract class View<T extends Endothermal> {
    public abstract void start();

    public abstract Presenter<T> getPresenter();
    public abstract String getPath();
    public abstract void setPath(String value);
    public void exit(){
        System.out.println("Good bye");
        System.exit(0);
    }
}
