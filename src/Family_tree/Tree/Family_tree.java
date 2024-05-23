package Family_tree.Tree;
import java.util.List;

import Family_tree.Humans.Gender;
import Family_tree.Humans.Human;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public class Family_tree {
    private List<Human> list;
    private long id;
    private String family;

    public Family_tree(String family){
        list = new ArrayList<>(); 
        this.family = family;
        Instant instant = Instant.now();
        this.id = instant.toEpochMilli();       
    }
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

    public void add(Human human){
        human.setInFamilyStatus(true);
        list.add(human);
    }    
    public void add(String name, Gender gender, LocalDate birthDate){
        Human human = new Human(name, gender, birthDate);
        human.setInFamilyStatus(true);
        list.add(human);
    }

    public Human search(String name){
        for (Human element : list) {
            if (element.getName().equalsIgnoreCase(name)){
                return element;
            }
        }
        return null;
    }
    public Human search(long id){
        for (Human element : list) {
            if (element.getID() == id){
                return element;
            }
        }
        return null;
    }

    public void excludeMember(Human human){
        human.setInFamilyStatus(false);
    }
    public List<Human> getFullList(){
        return this.list;
    } 
    public List<Human> getMemberList(){
        List<Human> memList = new ArrayList<>();
        for (Human human : this.list) {
            if (human.inFamily() == true){
                memList.add(human);
            }
        }
        return memList;
    }

    public void createUnion(){
        
    }


    
}
