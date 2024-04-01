package src.family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private List<Human> children;
    private Human mother, father;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name = " + name + "\ndob = " + dob +
                "\ndod = " + dod + "\ngender = " + gender +
                "\nchildren = " + children.getFirst().name +
                "\nmother = " + mother.name +
                "\nfather = " + father.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human child) {
        if (this.children == null) {
            this.children = List.of(child);
        } else {
            this.children.add(child);
        }
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }
}