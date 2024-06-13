package Family_tree.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Family_tree.Model.Service;
import Family_tree.Model.Tree.*;
import Family_tree.View.View;
import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Humans.Gender;

public abstract class Presenter<T extends Endothermal> {
    public abstract Service<T> getService();
    public abstract View<T> getView();
    public List<Family_tree<T>> getTreeList(){
        return getService().getTreeList();
    }
    public Family_tree<T> getActiveTree(){
        return getService().getCurrentTree();
    }
    public T getMember(int index){
        return getActiveTree().getItem(index);
    }
    public T getMember(int tree, int index){
        return getTreeList().get(tree).getItem(index);
    }
    public void removeMember(int index){
        getActiveTree().remove(index);
    }
    public abstract String createActiveTree(String value);
    public abstract String removeTree(int indrx);
    public abstract String showActiveTreeInfo();
    public abstract String loadTree(String path);
    public abstract String saveTree(String path);    
    public String showListTree(){
        if (getTreeList().size() == 0){
            return "Древо пусто";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getTreeList().size(); i++){
            sb.append(i);
            sb.append(". ");
            sb.append(getTreeList().get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    public abstract String selectTree(int index);
    public abstract void setActiveTree(Family_tree<T> tree);
    public boolean hasActiveTree(){
        if (getActiveTree() == null){
            return false;
        }else{
            return true;
        }
    }
    public abstract boolean newChild(String nane, Gender gender, LocalDate birthDate, int idfather, int idmother);
    public String searchByPattern(String pattern){
        return getService().searchByPattern(pattern);
    }
}
