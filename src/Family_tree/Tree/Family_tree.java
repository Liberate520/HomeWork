package Family_tree.Tree;
import Family_tree.Humans.ComparatorByAge;
import Family_tree.Humans.ComparatorByName;
import Family_tree.Humans.EndothermalInterface;
import java.io.Serializable;
import java.util.*;

public class Family_tree<T extends EndothermalInterface<T>> implements Serializable, Iterable<T>{
    private List<T> list;
    private long id;
    private String family;
    private long counter;

    public Family_tree(String family){
        list = new ArrayList<>(); 
        this.family = family;          
        this.counter = 0;     
    }
    public Family_tree(String family, long id){
        list = new ArrayList<>(); 
        this.family = family;          
        this.counter = 0; 
        this.id = id;    
    }

    public String getFamily(){ return this.family; }

    public void setid(long value){
        this.id = value;
    }
    public long getid(){
        return this.id;
    }
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
    public T search(int id){        
        return this.list.get(id);
    }

    public void excludeMember(T value){
        value.setInFamilyStatus(false);
    }
    public List<T> getFullList(){
        return this.list;
    } 
    public List<T> getMemberList(){
        List<T> memList = new ArrayList<>();
        for (T value : this.list) {
            if (value.inFamily() == true){
                memList.add(value);
            }
        }
        return memList;
    }  

    public String getlnfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("B дереве ");
        sb.append(list.size()); 
        sb.append(" объектов: \n"); 
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
        Collections.sort(this.list);
    }

   
    
}
