package Family_tree.Humans;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class Human {
    private long ID;
    private String  name;    
    private Human mother, father;
    private Set<Human> children;
    private LocalDate birthDate, deathDate;
    private Set<Link> links;
    private Vital vital;
    private Gender gender;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        this.children = new HashSet<>() ;
        this.birthDate = birthDate;
        this.deathDate = deathDate;    
        this.links = new HashSet<>() ;
        Instant instant = Instant.now();
        this.ID = instant.toEpochMilli();
        if (deathDate != null){
            this.vital = Vital.dead; 
        } else {
            this.vital = Vital.alive;
        }
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate,  null,  null,  null); 
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        this(name, gender, birthDate,  null, father, mother);
    }

    public boolean addChild(Human child){ 
        if (!children.contains(child)){ 
            children.add(child);
            if (this.gender == Gender.Female){
                child.setMother(this);
            } else {
                child.setFather(this);
            }
            return true;
        }
        return false;
    }

    public Human getMother(){
        return this.mother;
    }
    public void setMother(Human value){
        if (value.gender == Gender.Female){
            this.mother = value;
        } 
    }
    public Human getFather(){
        return this.father;
    }
    public void setFather(Human value){
        if (value.gender == Gender.Male){
            this.father = value;
        } 
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now()); 
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){ 
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public void setSpouse(Human spouse) { this.spouse = spouse; }
    public Human getSpouse(){ return this.spouse; }

    public Set<Human> getChildren() { return children; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate(LocalDate deathDate) { 
        if (deathDate == null){
            this.vital = Vital.alive;
        }else{
            this.vital = Vital.dead;
        }
        this.deathDate = deathDate; 
    }
    public Gender getGender(){ return gender; }
    public Vital getVital(){return this.vital;}
    public void setVital (Vital value){ this.vital = value;}

    @Override
    public String toString() {
        return getlnfo();
    }

    public long getID(){return this.ID;}
    public String getName(){return this.name;}


    



}
