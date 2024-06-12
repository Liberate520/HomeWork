package Family_tree.Presenter;

import java.util.List;

import Family_tree.Model.Service;
import Family_tree.Model.Tree.*;
import Family_tree.Model.Humans.Endothermal;

public abstract class Presenter<T extends Endothermal> {
    public abstract Service<T> getService();
    public List<Family_tree<T>> getTreeList(){
        return getService().getTreeList();
    }
    public Family_tree<T> getCurrentTree(){
        return getService().getCurrentTree();
    }
    public T getMember(int index){
        return getCurrentTree().getItem(index);
    }
    public T getMember(int tree, int index){
        return getTreeList().get(tree).getItem(index);
    }

}
