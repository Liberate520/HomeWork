package human;//package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    static int count = 0;
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth, dateOfDeath;
    private Human spouse;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Gender gender, int year, int month, int day) {
        this.id = count++;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = LocalDate.of(year, month, day);
        children = new ArrayList<>();
    }
    public Human(){
        this.id = count++;
    }

    //
    public String getName() {
        return this.name;
    }

    public int getAge() {
        int age;

        if (this.dateOfDeath == null) {
            LocalDate now = LocalDate.now();
            age = now.getYear() - this.dateOfBirth.getYear();
        } else {
            age = this.dateOfDeath.getYear() - this.dateOfBirth.getYear();
        }
        return age;
    }

    public void setDateOfDeath(int year, int month, int day) {
        this.dateOfDeath = LocalDate.of(year, month, day);
    }

    public String getSpouseName() {
        if (this.spouse != null) {
            return this.spouse.getName();
        } else {
            return "не в браке";
        }
    }

    public Human getSpouse() {
        return this.spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public String getParentsNames() {
        if (this.parents != null) {
            return parents.get(0).getName() + " " + parents.get(1).getName();
        } else {
            return "нет данных";
        }
    }

    public List<Human> getParents() {
        return this.parents;
    }

    public void setParents(Human father, Human mother) {
        this.parents = new ArrayList<Human>();
        this.parents.add(father);
        this.parents.add(mother);
    }

    public String getChildrenNames() {
        if (this.children != null) {
            String names = "";
            for (Human human : children) {
                names += human.name + " ";
            }
            return names;
        } else {
            return "детей нет";
        }
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public void setChild(Human child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        String result = "";

        result += String.format("id: %d", this.id);
        result += String.format(", имя: %s", getName());

        if (gender == Gender.MALE) {
            result += ", пол: муж";
        } else {
            result += ", пол: жен";
        }

        result += String.format(", возраст: %d", getAge());
        result += String.format(", супруг: %s", getSpouseName());
        result += String.format(", родители: %s", getParentsNames());
        result += String.format(", дети: %s", getChildrenNames());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        var e = (Human) obj;
        return this.id == e.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
