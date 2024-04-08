package family_tree;

import java.util.List;
import java.time.LocalDate;

public class Human {
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private List<Human> children;

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    private Human mother, father;

    public Human(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }
}
