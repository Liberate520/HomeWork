package Family_tree.Model.Tree;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

import Family_tree.Model.Humans.ComparatorByAge;
import Family_tree.Model.Humans.ComparatorByID;
import Family_tree.Model.Humans.ComparatorByName;
import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Recorder.Recorder;



public class Family_tree<T extends Endothermal>   implements  Iterable<T>, Serializable{
    private List<T> list;    
    private String family;
    private long innerID;
    private T activeSubject;
    private TreesCollection parent;

    public Family_tree(String family){
        long nameValue = 0;
        Instant instant = Instant.now(); 
        list = new ArrayList<>(); 
        this.family = family; 
        char[] chars = family.toCharArray();
        for (char iterable_element : chars) {
            nameValue = nameValue + (long) iterable_element;
        }
        this.innerID = instant.toEpochMilli() + nameValue;            
    } 
    //new for members join______________________________________________________
    public void setMemberList(List<T> value){
        this.list = value;
    }
    //______________________________________________________________________________
    public String getFamily(){ return this.family; }    
    
    @Override
    public String toString(){
        return this.family;
    }

    public void add(T value){
        if (value != null && !this.list.contains(value)){            
            list.add(value);            
        }  
        this.activeSubject = value;      
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

    public T searchByInnerID(long id){
        for (T t : list) {
            if (t.getInnerID() == id){
                return t;
            }
        }
        return null;
    }

    public Map<Integer, T> searchByPattern(String pattern){
        String str1 = pattern.toLowerCase();
        Map<Integer, T> result = new HashMap<>();
        for(int i = 0; i < this.list.size(); i++){
            if (this.list.get(i).getName().toLowerCase().contains(str1)){
                result.put(i, this.list.get(i));
            }
        }        
        return result;
    }  
    public T getItem(int id){        
        return this.list.get(id);
    }
    public T getItemByInnerID(long id){
        for (T t : list) {
            if(t.getInnerID() == id){
                return t;
            }
        }
        return null;
    }

    public void remove(T value){
        list.remove(value);
    }
    public void remove(int id){
        list.remove(id);
    }
    public void remove(long innerId){
        T aim = getItemByInnerID(innerId);
        list.remove(aim);
    }

    public List<T> getMemberList(){
        return this.list;
    }     

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("B дереве объектов: ");
        sb.append(list.size()); 
        sb.append("\n"); 
        for (int i = 0; i < list.size(); i++){ 
            sb.append(i);
            sb.append(" ");
            sb.append(list.get(i));            
            sb.append("\n"); 
        }
        return sb.toString();
    }

    
    public long getCount(){
        return list.size();
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

    public void save(String path){
        Recorder recorder = new Recorder();
        System.out.println(recorder.save(this, path));
    }

    public long getInnerID(){return this.innerID;}

    @SuppressWarnings("unchecked")
    public int getIndex() {
        return parent.getIndex(this);
    }

    public int getItemIndex(T value) {
        try{
            for (int i = 0; i < this.list.size(); i++){
                if (value.equals(this.list.get(i))){
                    return i;
                }
            }
            return -1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
    
   public T getActiveItem() {
    return this.activeSubject;
   } 

   public boolean setActiveItem (int index){
    try{
        this.activeSubject = this.list.get(index);
        return true;
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
   }

   public boolean setActiveItem(long ID){
    try{
        T element = this.getItemByInnerID(ID);
        this.activeSubject = element;
        return true;
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
   }
}

    
    

