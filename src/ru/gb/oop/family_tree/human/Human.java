package ru.gb.oop.family_tree.human;

import java.io.Serializable;
import java.util.*;

public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String name;
    private Sex sex;
    private Date birthDate, deathDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(int id, String name, Sex sex, Date birthDate, Date deathDate, List<Human> parents, List<Human> children) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents != null ? parents : new ArrayList<>();
        this.children = children != null ? children : new ArrayList<>();
    }

    public Human(int id, String name, Sex sex, Date birthDate, List<Human> parents) {
        this(id, name, sex, birthDate, null, parents, null);
    }

    public Human(int id, String name, Sex sex, Date birthDate) {
        this( id, name, sex, birthDate, null, null, null);
    }

    public boolean isCorrect() {
        return name != null
                && sex != null
                && birthDate != null
                && (deathDate == null || deathDate.after(birthDate));
    }

    public void setParents(List<Human> parents) {
        if (parents == null || parents.isEmpty() || parents.size() > 2 || parents.get(0).getSex() == parents.get(1).getSex()) {
            throw new IllegalArgumentException();
        } else {
            this.parents = parents;
            for (Human parent : parents) {
                parent.addChild(this);
            }
        }
    }

    public int getAge() {
        Calendar berthDate = Calendar.getInstance();
        berthDate.setTime(birthDate);
        Calendar endDate = Calendar.getInstance();
        if (deathDate != null) {
            endDate.setTime(deathDate);
        }

        int age = endDate.get(Calendar.YEAR) - berthDate.get(Calendar.YEAR);
        return age;
    }

    public void addChild(Human child) {
        children.add(child);
    }


    public List<Human> getParents() {
        return parents;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }


    public List<Human> getChildren() {
        return children;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + sex + " " + this.getAge();
    }

    @Override
    public int compareTo(Human o) {
        return 0;
    }
}
