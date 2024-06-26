package ru.gb.oop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human {
    private String name;
    private Sex sex;
    private Date birthDate, deathDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Sex sex, Date birthDate, Date deathDate, List<Human> parents, List<Human> children) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents != null ? parents : new ArrayList<>();
        this.children = children != null ? children : new ArrayList<>();
    }

    public Human(String name, Sex sex, Date birthDate, List<Human> parents) {
        this(name, sex, birthDate, null, parents, null);
    }

    public Human (String name, Sex sex, Date birthDate) {
        this(name, sex, birthDate, null, null, null);
    }

    public boolean isCorrect() {
        return name != null
                && sex != null
                && birthDate != null
                && deathDate.after(birthDate);
    }

    public void setParents(List<Human> parents) {
        if (parents != null
                && parents.size() == 2
                && ((parents.get(0).getSex() == Sex.Male && parents.get(1).getSex() == Sex.Female) || (parents.get(0).getSex() == Sex.Female && parents.get(1).getSex() == Sex.Male))) {
            this.parents = parents;
        } else {
            Main.logger.warning("Error: parents must be male and female" + parents);
            throw new IllegalArgumentException("Error: parents must be male and female");
        }
    }

    public void setChildren(List<Human> children) {
        if (children != null)
            this.children = children;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nSex: " + sex + "\nBirthDate: " + birthDate + "\nDeathDate: " + deathDate;
    }
}
