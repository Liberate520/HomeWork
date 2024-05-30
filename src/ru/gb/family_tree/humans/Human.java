package ru.gb.family_tree.humans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate date_of_birth;
    private LocalDate date_of_death;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;


    public Human(String name, Gender gender, LocalDate date_of_birth,
                 LocalDate date_of_death, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.date_of_death = date_of_death;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate date_of_birth) {
        this(name, gender, date_of_birth, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate date_of_birth, Human father, Human mother) {
        this(name, gender, date_of_birth, null, father, mother);
    }

    public boolean addChild (Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent (Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }



    public int getAge() {
        if (date_of_death == null) {
            return getPeriod(date_of_birth, LocalDate.now());
        }
        else {
            return getPeriod(date_of_birth, date_of_death);
        }
    }

    private int getPeriod(LocalDate date_of_birth, LocalDate date_of_death) {
        Period diff = Period.between(date_of_birth, date_of_death);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
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

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public LocalDate getDate_of_death() {
        return date_of_death;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setDate_of_death(LocalDate date_of_death) {
        this.date_of_death = date_of_death;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", Имя: ");
        sb.append(name);
        sb.append(", Пол: ");
        sb.append(gender);
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        }
        else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        }
        else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getMother();
        if (father != null) {
            res += father.getName();
        }
        else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }
        else {
            res.append("отсутствует");
        }
        return res.toString();
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
