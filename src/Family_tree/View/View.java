package Family_tree.View;



public abstract class View{
    private ActionLevel level = ActionLevel.TreeLevel;
    public abstract void start();    
    public ActionLevel getActionLevel(){
        return level;
    }  
    public abstract void setActionLevel(ActionLevel value);  
    
    
     
}
