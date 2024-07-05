package family__tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {

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

    // Getters and setters

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

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
        if (this.gender == Gender.Male) {
            child.setFather(this);
        } else if (this.gender == Gender.Female) {
            child.setMother(this);
        }
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getParents() {
        String fatherName = (father != null) ? father.getName() : "отец неизвестен";
        String motherName = (mother != null) ? mother.getName() : "мать неизвестна";
        return "Отец: " + fatherName + ", Мать: " + motherName;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ". Год рождения: " + birth + ". Пол: " + gender + ".";
    }
}