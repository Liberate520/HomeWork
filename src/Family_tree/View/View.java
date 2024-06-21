package Family_tree.View;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Presenter.Presenter;

public abstract class View<T extends Endothermal> {
    private ActionLevel level = ActionLevel.TreeLevel;
    public abstract void start();
    public abstract Presenter getPresenter(); 
    public ActionLevel getActionLevel(){
        return level;
    }  
    public abstract void setActionLevel(ActionLevel value);  
    
    
     
}
