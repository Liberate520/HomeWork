package Family_tree.Humans;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import Family_tree.Gender;

public abstract class Human {
    private long ID;
    private String  name;    
    private Human mother, father;
    private Set<Human> children;
    private LocalDate birthDate, deathDate;
    private Set<Human> partners;
    private Vital vital;

    public Human(String name, Human mother, Human father, Vital vital, LocalDate birthDate, LocalDate deathDate){
        Instant instant = Instant.now();
        long ID = instant.toEpochMilli();





    }
    

    public String getName (){
        return this.name;
    }
    public Gender getGender (){
        return this.gender;
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
        this.deathDate = value;
    }
    public Human getMother(){
        return this.mother;
    }    
    public Human getFather(){
        return this.father;
    }
    //public void addPartner(){
        //partners.add(human);
    //}
    public void addChild(Human child){
        children.add(child);
    }

    @Override
    public String toString(){
        return (this.gender.toString() + ": " + this.name);        
    }

    public Set<Human> getChildren(){
        return children;
    }
    public Set<Human> getPartners(){
        return partners;
    }
    public Human(String name, Gender gender, LocalDate bday){
        humaninit(name, gender, bday);
    }

    public String showInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append('\n');
        sb.append("BirthDate: ");
        if (birthDate == null){
            sb.append("-\n");
        }else{            
            sb.append(birthDate.toString());
            sb.append('\n');            
        }
        sb.append("DeathDate: ");
        if (deathDate == null){
            sb.append("-\n");
        }else{            
            sb.append(deathDate.toString());
            sb.append('\n');            
        }
        sb.append("Mother: ");
        if (mother == null){
            sb.append("-");
        }else{
            sb.append(mother);
        }
        sb.append(" Father: ");
        if (father == null){
            sb.append("-");
        }else{
            sb.append(father);
        }
        sb.append('\n');
        sb.append("Partners: \n");
        if (partners.size() == 0){
            sb.append("-\n");
        }else{
            for (Human human : partners) {
                sb.append(human);
                sb.append('\n');
            }
        }
        sb.append("Children: \n");
        if (children.size() == 0){
            sb.append("-\n");
        }else{
            for (Human human : children) {
                sb.append(human);
                sb.append('\n');
            }
        }
        return sb.toString();
    }



}
