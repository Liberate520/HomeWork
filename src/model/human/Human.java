package model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Element, Serializable {
    private String name;
    private LocalDate dateOfBirthday, dateOfDeath;
    private Gender gender;
    private Element father, mother;
    private List<Element> childrenList;
    private int id;

    public Human() {
    }

    public Human(String name, LocalDate dateOfBirthday, LocalDate dateOfDeath, Gender gender, Element father, Element mother, List<Element> children) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.childrenList = new ArrayList<>();
        this.id = -1;
    }

    public Human(String name, LocalDate dateOfBirthday, LocalDate dateOfDeath, Gender gender) {
        this(name, dateOfBirthday, dateOfDeath, gender, null, null, null);
    }

    public Human(String name, LocalDate dateOfBirthday, Gender gender) {
        this(name, dateOfBirthday, null, gender, null, null, null);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFather(Element father) {
        this.father = father;
    }

    public void setMother(Element mother) {
        this.mother = mother;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getAge() {
        Period period = Period.between(this.dateOfBirthday, LocalDate.now());
        return period.getYears();
    }

    @Override
    public void addParent(Element human) {
        if (human.getGender() == Gender.Male) {
            setFather(human);
        } else {
            setMother(human);
        }
        human.addChild(this);
    }

    @Override
    public void addChild(Element human) {
        if (!this.childrenList.contains(human)) {
            this.childrenList.add(human);
            human.addParent(this);
        }
    }

    public String getMother() {
        if (mother != null) {
            return this.mother.getName();
        } else
            return "неизв.";
    }

    public String getName(String name) {
        return this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFather() {
        if (father != null) {
            return this.father.getName();
        } else
            return "неизв.";
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!childrenList.isEmpty()) {
            for (Element human : childrenList) {
                stringBuilder.append(human.getName());
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        } else
            return "нет";
    }

    @Override
    public String toString() {

        return "[ID: " + getID() +
                "] Имя: " + this.name +
                ", Возраст: " + getAge() +
                ", пол: " + this.gender +
                ", отец: " + getFather() +
                ", мать: " + getMother() +
                ", дети: " + getChildren();
    }
}

