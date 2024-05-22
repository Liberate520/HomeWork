package homeWork.family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate dayOfBirth, dayOfDeath;
    private Human father, mother;
    private List<Human> children;
    private Gender gender;

    public Human(String name, LocalDate dayOfBirth, Gender gender) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.children = new ArrayList<>();
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", dayOfBirth: " + dayOfBirth +
                ", dayOfDeath: " + dayOfDeath +
                ", father: " + father +
                ", mother: " + mother +
                ", children: " + children +
                ", gender: " + gender;
    }
}