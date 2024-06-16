package Family_tree.Model;

import java.time.LocalDate;
import java.util.*;
import Family_tree.Model.Tree.*;
import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Recorder.Recorder;


public /*abstract*/ class Service<T extends Endothermal>  {




/* Усё в топку (сопли до полу)
    public abstract List<Family_tree<T>> getTreeList();
    public Family_tree<T> getTree(int index){
        return getTreeList().get(index);
    };
    public abstract void setCurrentTree(int index);
    public void addTree(String name){
        Family_tree<T> newtree = new Family_tree<T>(name);
        setCurrentTree(newtree);
        getTreeList().add(newtree);
    };
    public Family_tree<T> getTree(String name){
        for (Family_tree<T> element : getTreeList()) {
            if (element.getFamily().equals(name)){
                return element;
            }
        }
        return null;
    }    
    public abstract void setCurrentTree(Family_tree<T> tree);
    public abstract Family_tree<T> getCurrentTree();
    public boolean removeTree(int index){
        try{
            getTreeList().remove(index);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    };
    public abstract boolean newChild(T child, T father, T mother);
    public boolean saveTree(String path, int index){
        Family_tree<T> current = getTree(index);
        try{
            current.save(path);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public Family_tree<T> loadTree(String path){
        Recorder recorder = new Recorder();
        Object obj = recorder.read(path);
        @SuppressWarnings("unchecked")
        Family_tree<T> newtree = (Family_tree<T>) obj;
        boolean boo = true;
        for (Family_tree<T> element : getTreeList()) {
            if (newtree.getFamily().equals(element.getFamily())){
                element = newtree;
                boo = false;
            } 
        }
        if(boo){
            getTreeList().add(newtree);
        }
        setCurrentTree(newtree);
        return newtree;
    }
    public boolean saveTree(String path){        
        try{
            getCurrentTree().save(path);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public String searchByPattern(String pattern){
        String str1 = pattern.toLowerCase();
        Map<Integer,T> result = new HashMap<Integer, T>();
        for (int i = 0; i < getCurrentTree().getMemberList().size(); i++){
            if (getCurrentTree().getMemberList().get(i).toString().toLowerCase().contains(str1)){
                result.put(i, getCurrentTree().getMemberList().get(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Результат поиска:\n");
        if (result.isEmpty()){
            sb.append("Ничего не найдено");
            return sb.toString();
        }
        for(Map.Entry<Integer, T> set : result.entrySet()){
            sb.append(set.getKey());
            sb.append(" ");
            sb.append(set.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }  
    public abstract String addToTree(String name, Gender gender, LocalDate birthDate);
*/
}
