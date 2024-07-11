package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate dob, Gender gender, Human father, Human mother) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    @Override
    public String toString() {
        return name + " (" + dob + " - " + (dod != null ? dod : "present") + ")";
    }
}
