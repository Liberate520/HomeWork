package family__tree.model.human;

import family__tree.model.family_tree_service.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, ItemFamilyTree<Human> {
    private static final long serialVersionUID = 1L;

    private String name;
    private LocalDate birth;
    private LocalDate death;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birth, Gender gender) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int birthYear = birth.getYear();
        return currentYear - birthYear;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
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

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public void addChild(Human child) {
        this.children.add(child);
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ". Год рождения: " + birth + ". Пол: " + gender + ".";
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}