import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {

    String name;
    Gender gender;
    LocalDate birthDate;
    LocalDate deathDate;
    List<Human> parents;
    List<Human> children;
    List<Human> grandparents;


    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.grandparents = new ArrayList<>();
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public String toString() {
        return name + " (" + gender + ", родился: " + birthDate + ")";
    }
}


