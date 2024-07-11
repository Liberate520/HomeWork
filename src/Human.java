import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{

    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> children;
    private List<Human> parents;
    //private List<Relationship> relationships;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        //this.relationships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public void addChild(Human child) {
        children.add(child);
        child.addParent(this);
    }

    public void addParent(Human parent) {
        if (parents.size() < 2) {
            parents.add(parent);
        }
    }

    @Override
    public String toString() {
        return name + " (" + gender + "), Birth Date: " + birthDate + (deathDate != null ? ", Death Date: " + deathDate : "");
    }
}
