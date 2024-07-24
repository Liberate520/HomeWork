package model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.family_tree.ItemFamilyTree;

public class Human implements Serializable, ItemFamilyTree {
    private int id;
    private String name;
    private LocalDate dateOfBirth, dateOfDeath;
    private Gender gender;
    private Human mother, father;
    private List<Human> children;

    public Human(int id, String name, Gender gender, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public int getAge() {
        if (this.dateOfDeath == null) {
            return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
        } else {
            return Period.between(this.dateOfBirth, this.dateOfDeath).getYears();
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human human) {
        this.children.add(human);
    }

    public String toString() {
        String humanInfo = "";
        humanInfo += "id: " + id + "\n"
        + "name: " + name + "\n"
        + "gender: " + gender + "\n"
        + "dateOfBirth: " + dateOfBirth + "\n";
        if (dateOfDeath != null){
            humanInfo += "dateOfDeath: " + dateOfDeath + "\n";
        }
        humanInfo += "age: " + getAge();
        return humanInfo;
    }

}
