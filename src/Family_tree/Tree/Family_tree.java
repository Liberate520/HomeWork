package Family_tree.Tree;
import Family_tree.Humans.ComparatorByAge;
import Family_tree.Humans.ComparatorByID;
import Family_tree.Humans.ComparatorByName;
import Family_tree.Humans.Endothermal;
import java.util.*;

public class Family_tree<T extends Endothermal>   implements  Iterable<T>{
    private List<T> list;    
    private String family;
    private long counter;

    public Family_tree(String family){
        list = new ArrayList<>(); 
        this.family = family;          
        this.counter = 0;     
    } 

    public String getFamily(){ return this.family; }    
    
    @Override
    public String toString(){
        return this.family;
    }

    public void add(T value){
        if (value != null && !this.list.contains(value)){            
            list.add(value);
            this.counter ++;
        }        
    }      

    public List<T> searchByName(String name){
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (element.getName().equalsIgnoreCase(name)){
                result.add(element);
            }
        }
        return result;
    }
    public T getItem(int id){        
        return this.list.get(id);
    }

    public void excludeMember(T value){
        value.setInFamilyStatus(false);
    }
    public List<T> getMemberList(){
        return this.list;
    }     

    public String getlnfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("B дереве объектов: ");
        sb.append(list.size()); 
        sb.append("\n"); 
        for (T value: list){ 
            sb.append(value);            
            sb.append("\n"); 
        }
        return sb.toString();
    }

    
    public long getCount(){
        return this.counter;
    }
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void sortByName(){
        this.list.sort(new ComparatorByName<T>());
        
    }
    public void sortByAge(){
        this.list.sort(new ComparatorByAge<T>());
    }
    public void sortByInnerId(){
        this.list.sort(new ComparatorByID<T>());
    }   
    
}
