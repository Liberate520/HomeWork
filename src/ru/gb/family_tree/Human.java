package ru.gb.family_tree;

import ru.gb.family_tree.util.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private String secondName;
    private Gender gender;
    private LocalDate dayOfBirth, dayOfDeath;
    private Human mother, father;
    private List<Human> children;
    private Human spouse;

    public Human(String name, String secondName, Gender gender, LocalDate dayOfBirth, LocalDate dayOfDeath, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.dayOfDeath = dayOfDeath;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String name, String secondName, Gender gender, LocalDate dayOfBirth) {
        this(name, secondName, gender, dayOfBirth, null, null, null);
    }

    public Human(String name, String secondName, Gender gender, LocalDate dayOfBirth, Human father, Human mother) {
        this(name, secondName, gender, dayOfBirth, null, father, mother);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            if (father != null) {
                setFather(parent);
                return true;
            } else {
                return false;
            }
        }
        if (parent.getGender().equals(Gender.Female)) {
            if (mother != null) {
                setMother(parent);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
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

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    private int getPeriod(LocalDate dayOfBirth, LocalDate dayOfDeath) {
        Period period = Period.between(dayOfBirth, dayOfDeath);
        return period.getYears();
    }

    public int getAge() {
        if (dayOfDeath == null) {
            return getPeriod(dayOfBirth, LocalDate.now());
        } else {
            return getPeriod(dayOfBirth, dayOfDeath);
        }
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public getInfo() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Helpers.formatDataString("id", String.valueOf(id)));
        sb.append(Helpers.formatDataString("name", name));
        sb.append(Helpers.formatDataString("second name", secondName));
        sb.append(Helpers.formatDataString("gender", String.valueOf(getGender())));
        sb.append(Helpers.formatDataString("age", String.valueOf(getAge())));
        sb.append(Helpers.formatDataString("age", String.valueOf(getAge())));

//                Helpers.formatDataString("birth date", dob.toString()) + "\n";
        return sb.toString();
    }

    @Override
    public boolean equals () {
        return true;
    }
}
