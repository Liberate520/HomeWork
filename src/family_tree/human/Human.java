package family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private int id;
    private String name;
    private String surName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDead;
    private List<Human> children;
    private List<Human> parents;
    private Sex sex;

    public Human(String name, String surName, LocalDate dateOfBirth, LocalDate dateOfDead, Sex sex,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDead = dateOfDead;
        this.sex = sex;
        parents = new ArrayList<>();
        if (father != null) parents.add(father);
        if (mother != null) parents.add(mother);
        children = new ArrayList<>();
    }

    public Human(String name, String surName, LocalDate dateOfBirth, Sex sex, Human father, Human mother) {
        this(name, surName, dateOfBirth, null, sex, father, mother);
    }

    public Human(String name, String surName, LocalDate dateOfBirth, Sex sex) {
        this(name, surName, dateOfBirth, null, sex, null, null);
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

    public int getAge() {
        return getAgeCalculate(dateOfBirth, Objects.requireNonNullElseGet(dateOfDead, LocalDate::now));
    }

    private int getAgeCalculate(LocalDate dateOfBirth, LocalDate dateOfDead) {
        Period result = Period.between(dateOfBirth, dateOfDead);
        return result.getYears();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfDead() {
        return dateOfDead;
    }

    public void setDateOfDead(LocalDate dateOfDead) {
        this.dateOfDead = dateOfDead;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return infoAboutHuman();
    }

    public String infoAboutHuman() {
        StringBuilder sb = new StringBuilder();
        sb.append("член семьи: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", фамилия: ");
        sb.append(surName);
        sb.append(", пол: ");
        sb.append(sex);
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", родители: ");
        sb.append(getParentsInfo());
        sb.append(", дети: ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getParentsInfo() {
        StringBuilder result = new StringBuilder();
        if (!parents.isEmpty()) {
            for (Human parent : parents) {
                result.append(parent.getName());
                result.append(" ");
            }
        } else {
            result.append("нет информации");
        }
        return result.toString();
    }

    public String getChildrenInfo() {
        StringBuilder result = new StringBuilder();
        if (!children.isEmpty()) {
            for (Human child : children) {
                result.append(child.getName());
                result.append(" ");
            }
        } else {
            result.append("нет");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Human human)) {
            return false;
        }
        return human.getId() == (getId());
    }
}
