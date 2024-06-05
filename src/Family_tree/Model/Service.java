package Family_tree.Model;

import java.io.Serializable;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Tree.Family_tree;

public class Service<T extends Endothermal> implements Serializable{

    private Family_tree<T> tree;    
    private int counter;      
    private T currentItem;

    public Service(String family) {
        tree = new Family_tree<>(family);         
        this.counter = 0;        
    }    
    
    public void addItem(T value){ 
        if (!tree.getMemberList().contains(value)) {     
            value.setFamilyID(counter);
            counter++;
            tree.add(value);         
        }
    }
    public Family_tree<T> getTree(){
        return tree;
    }
    public T getItem(int index){
        if (tree.getMemberList().size() == 0){
            return null;
        }
        currentItem = this.tree.getMemberList().get(index);
        return currentItem;
    }
    public String getItemsInfo(){
        
        StringBuilder sb = new StringBuilder();
        sb.append("Список членов семьи " + tree.getFamily() + " \n");
        for (T value : tree) {
            sb.append(value + "\n");
        }
        return sb.toString();
    }
    public void SortByName(){
        tree.sortByName();
    }
    public void SortByID(){
        tree.sortByInnerId();
    }
    public void SortByAge(){
        tree.sortByAge();
    }

    

}
