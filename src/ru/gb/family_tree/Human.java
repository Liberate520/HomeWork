package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private long id;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;
    private Human marriedPartner;

    public Human(String name, String lastName, Gender gender, LocalDate dateOfBirth,
                 LocalDate dateOfDeath, Human father, Human mather) {
        id = -1;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mather != null) {
            parents.add(mather);
        }
        children = new ArrayList<>();

    }

    public Human(String name, String lastName, Gender gender, LocalDate dateOfBirth) {
        this(name, lastName, gender, dateOfBirth, null, null, null);
    }

    public Human(String name, String lastName, Gender gender, LocalDate dateOfBirth,
                 Human father, Human mather) {
        this(name, lastName, gender, dateOfBirth, null, father, mather);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (!children.contains(parent)) {
            children.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.мужской) {
                return parent;
            }
        }
        return null;
    }

    public Human getMather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.женский) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period diff = Period.between(dateOfBirth, dateOfDeath);
        return diff.getYears();
    }

    public void setMarriedPartner(Human marriedPartner) {
        this.marriedPartner = marriedPartner;
    }

    public Human getMarriedPartner() {
        return marriedPartner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    //    public Human(String иван, String гагарин) {
//    }

    @Override
    public String toString() {
        return "Human{" +
                "Имя: " + name +
                ", Фамилия: " + lastName +
                ", пол: " + gender +
                ", годы жизни: " + dateOfBirth +
                " - " + dateOfDeath +
                ", родители: " + parents +
                ", дети: " + children +
                ", супруг: " + marriedPartner +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

}


