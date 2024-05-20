package Family_tree.Humans;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;


public abstract class Human {
    private long ID;
    private String  name;    
    private Human mother, father;
    private Set<Human> children;
    private LocalDate birthDate, deathDate;
    private Set<Link> links;
    private Vital vital;

    public Human(String name, Female mother, Male father, LocalDate birthDate, LocalDate deathDate){
        Instant instant = Instant.now();
        this.ID = instant.toEpochMilli();
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.vital = Vital.dead; 
        this.children = new HashSet<>();
        this.links = new HashSet<>();
    }
    public Human(String name){
        this(name, null, null, null, null);
        this.vital = Vital.alive;
    }

    public String getName (){
        return this.name;
    }  
    public Human getFather(){
        return this.father;
    }
    public void setFather(Male male){
        this.father = male;
    }
    public Human getMother(){
        return this.mother;
    } 
    public void setMother(Female value){
        this.mother = value;
    }  
    public LocalDate getBirhDate(){
        return this.birthDate;
    }
    public void setBirhDate(LocalDate value){
        this.birthDate = value;
    }
    public LocalDate getDeathDate(){        
        return this.deathDate;                
    }
    public void setDeathDate(LocalDate value){
        this.vital = Vital.dead;
        this.deathDate = value;
    }
    public Vital getVital(){
        return this.vital;
    }
    public void setVital(Vital value){
        this.vital = value;
    }
    
    public void addChild(Human child){
        children.add(child);
    }

    @Override
    public String toString(){
        return (this.name);        
    }

    public Set<Human> getChildren(){
        return this.children;
    }
    public Set<Link> getLinks(){
        return this.links;
    }
    public long getID(){
        return this.ID;
    }
   

    



}
