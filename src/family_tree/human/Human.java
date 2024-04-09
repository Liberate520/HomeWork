package family_tree.human;

import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private List<Human> children;
    private Human mother, father;

    public Human(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dob;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setDateOfDeath(LocalDate dod) {
        this.dod = dod;
    }

    public LocalDate getDateOfDeath() {
        return dod;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Gender getGender() {
        return gender;
    }
}
