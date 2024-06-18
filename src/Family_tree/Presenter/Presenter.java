package Family_tree.Presenter;
import java.util.List;
import Family_tree.Model.Service;
import Family_tree.Model.Tree.*;
import Family_tree.View.View;
import Family_tree.Model.Humans.Endothermal;


public abstract class Presenter<T extends Endothermal> {
    public abstract Service<T> getService();
    public abstract View<T> getView();
    public abstract String getTreeList();
    public abstract Family_tree<T> getActiveTree();
    public abstract T getMember(int index);
    public abstract T getMember(int tree, int index); 
    public abstract String removeMember();
    public abstract String createActiveTree(String value);
    public abstract String removeTree();
    public abstract String showActiveTreeInfo();
    public abstract String loadTree(String path);
    public abstract String saveTree(String path); 
    
    public abstract String selectTree(int index);
    public abstract void setActiveTree(Family_tree<T> tree);
    public boolean hasActiveTree(){
        if (getActiveTree() == null){
            return false;
        }else{
            return true;
        }
    }
    public abstract String newChild(String nane, String gender, String birthDate, int idfather, int idmother);
    public String searchByPattern(String pattern){
        return getService().searchByPattern(pattern);
    }
    public abstract String addToTree(String name, String gender, String birthDate);

    public abstract String showActiveSubjectInfo();

    public abstract String setDeathDate(String nextLine) ;
    
    public abstract String showSubjectList(); 
    

    

}
