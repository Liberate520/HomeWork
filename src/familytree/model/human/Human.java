package familytree.model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import familytree.model.family_tree.TreeElement;

public class Human implements TreeElement<Human> {    
    private static final long serialVersionUID = 1L;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;   
    private List<Human> children;
    private List<Human> parents;
  
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {       
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }
    public Human(String name, Gender gender, LocalDate birthDate) {        
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }
   
    public String getName() {
        return name;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)              
          .append(", Gender: ").append(gender)
          .append(", Age: ").append(calculateAge())
          .append(", Children: ");
        if (children.isEmpty()) {
            sb.append("None");
        } else {          
            for (Human child : children) {
                sb.append(child.name).append(", ");
            }
        }
        sb.append(", Parents: ");
        if (parents.isEmpty()) {
            sb.append("None");
        } else {
            for (Human parent : parents) {
                sb.append(parent.name).append(", ");
            }
        }
        return sb.toString();
    }

    public int calculateAge() {
         LocalDate endDate; 
        if (deathDate != null){
            endDate = deathDate; 
        } else {
            endDate = LocalDate.now();
        }
        return Period.between(this.birthDate, endDate).getYears();

    }
}