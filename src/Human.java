package family;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public Human(String name2, int i, Gender male) {
        //TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthYear() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        if (father != null) {
            father.addChild(this);
        }
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if (mother != null) {
            mother.addChild(this);
        }
    }

    public List<Human> getChildren() {
        return children;
    }

    private void addChild(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Год рождения: " + birthDate + ", Пол: " + gender;
    }
}