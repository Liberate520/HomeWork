package Family_tree.Humans;
import java.time.Instant;
import java.time.LocalDate;
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
   
    



}
