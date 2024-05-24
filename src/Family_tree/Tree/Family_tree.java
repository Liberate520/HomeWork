package Family_tree.Tree;
import Family_tree.Humans.Gender;
import Family_tree.Humans.Human;
import Family_tree.Humans.Link;
import Family_tree.Humans.LinkType;

import java.time.Instant;
import java.time.LocalDate;

import java.util.*;

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
        if (human != null && !this.list.contains(human)){
            human.setInFamilyStatus(true);
            list.add(human);
        }        
    }    
    public void add(String name, Gender gender, LocalDate birthDate){
        Human human = new Human(name, gender, birthDate);
        human.setInFamilyStatus(true);
        list.add(human);
    }

    public List<Human> searchByName(String name){
        List<Human> result = new ArrayList<>();
        for (Human element : list) {
            if (element.getName().equalsIgnoreCase(name)){
                result.add(element);
            }
        }
        return result;
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

    public void createUnion(LocalDate start, Human male, Human female, LinkType type){
        Link newlink = new Link(type, male, female, true, start, null);
        male.getLinks().add(newlink);
        female.getLinks().add(newlink);
    }

    public Link searchLink(Human male, Human female, LinkType type){
        Set<Link> mSet = male.getLinks();
        for (Link link : mSet) {
            if (link.getFemale().equals(female) && link.getType().equals(type)){
                return link;
            }
        }
        return null;
    }

    public Set<Human> getSiblings(long id){ 
        Human human = this.search(id); 
        if (human == null){
            return null;
        }
        Set<Human> res = new HashSet<>();
        Human father = human.getFather();
        res.addAll(father.getChildren());
        Human mother = human.getMother();
        res.addAll(mother.getChildren());
        res.remove(human);
        return res;
    }

    public String getlnfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("B дереве ");
        sb.append(list.size()); 
        sb.append(" объектов: \n"); 
        for (Human human: list){ 
            sb.append(human);            
            sb.append("\n"); 
        }
        return sb.toString();
    }


    
}
