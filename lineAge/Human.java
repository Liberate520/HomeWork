package com.oop.homeWorkOOP.lineAge;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.oop.homeWorkOOP.Gender;

public class Human implements Serializable {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, int bDay, int bMonth, int bYear, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthDate = LocalDate.of(bYear, bMonth, bDay);
        this.father = father;
        this.mother = mother;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.deathDate = null;
    }

    public Human(String name, int bDay, int bMonth, int bYear, Gender gender, Human father, Human mother,
            List<Human> children) {
        this(name, bDay, bMonth, bYear, gender, father, mother);
        if (children != null) {
            this.children = children;
        }
    }

    public Human(String name, int bDay, int bMonth, int bYear, int dDay, int dMonth, int dYear, Gender gender,
            Human father, Human mother) {
        this(name, bDay, bMonth, bYear, gender, father, mother);
        this.deathDate = LocalDate.of(dYear, dMonth, dDay);
    }

    public Human(String name, int bDay, int bMonth, int bYear, int dDay, int dMonth, int dYear, Gender gender,
            Human father, Human mother, List<Human> children) {
        this(name, bDay, bMonth, bYear, dDay, dMonth, dYear, gender, father, mother);
        if (children != null) {
            this.children = children;
        }
    }

    public int getAge() {
        if (deathDate == null) {
            return LocalDate.now().getYear() - birthDate.getYear();
        }
        return deathDate.getYear() - birthDate.getYear();
    }

    @Override
    public String toString() {
        return getDataToString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (birthDate == null) {
            if (other.birthDate != null)
                return false;
        } else if (!birthDate.equals(other.birthDate))
            return false;
        return true;
    }

    private String getDataToString() {
        StringBuilder res = new StringBuilder();
        res.append("Name: ");
        res.append(name);
        res.append(", age: ");
        res.append(", gender: ");
        res.append(gender);
        res.append(getAge());
        res.append(", birthDate: ");
        res.append(birthDate);
        if (deathDate != null) {
            res.append(", deathDate: ");
            res.append(deathDate);
        }
        res.append("\n\t\tfather: ");
        if (father == null) {
            res.append("Неизвестен");
        } else {
            res.append(father.getName());
        }
        res.append("\n\t\tmother: ");
        if (mother == null) {
            res.append("Неизвестена");
        } else {
            res.append(mother.getName());
        }
        res.append("\n\t\t children: ");
        if (children.size() == 0) {
            res.append("Пока нет");
        } else {
            for (Human hum : children) {
                res.append(hum.getName());
                res.append(", ");
            }
            res.delete(res.length() - 2, res.length() - 1);
        }
        res.append("\n");
        return res.toString();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {

        return deathDate;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getParents() {
        List<Human> res = new ArrayList<>();
        if (father != null) {
            res.add(father);
        }
        if (mother != null) {
            res.add(mother);
        }
        return res;
    }

    public List<Human> getChildren() {
        return children;
    }

    public boolean addChild(Human human) {
        if (children.contains(human)) {
            return false;
        }
        children.add(human);
        return true;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

}
