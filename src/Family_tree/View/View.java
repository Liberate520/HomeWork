package Family_tree.View;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Presenter.Presenter;

public abstract class View<T extends Endothermal> {
    public abstract void start();
    public abstract Presenter<T> getPresenter();
    public boolean hasActiveTree(){       
        if (getPresenter().getActiveTree() == null){
            return false;
        }
        return true;
    }
    public void exit(){
        System.out.println("Good bye");
        System.exit(0);
    }
    public abstract String addToTree(T value); 
}
