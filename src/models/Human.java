package models;

import enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для представления человека в генеалогическом древе.
 */
public class Human implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private List<Human> mothers;
    private List<Human> fathers;
    private List<Human> children;
    private Human spouse;

    public Human(String name, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender) {
        this.id = System.identityHashCode(this);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.mothers = new ArrayList<>();
        this.fathers = new ArrayList<>();
        this.children = new ArrayList<>();
        this.spouse = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Human> getMothers() {
        return mothers;
    }

    public List<Human> getFathers() {
        return fathers;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void addMother(Human mother) {
        this.mothers.add(mother);
    }

    public void addFather(Human father) {
        this.fathers.add(father);
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(dateOfBirth).append(" — ");
        if (dateOfDeath != null) {
            sb.append(dateOfDeath);
        } else {
            sb.append("жив");
        }
        sb.append("\nОтец: ");
        for (Human father : fathers) {
            sb.append(father.getName()).append(" ");
        }
        sb.append("\nМать: ");
        for (Human mother : mothers) {
            sb.append(mother.getName()).append(" ");
        }
        sb.append("\nБратья/Сестры: ");
        for (Human sibling : getOtherChildren()) {
            sb.append(sibling.getName()).append(" ");
        }
        sb.append("\nСупруг(а): ");
        if (spouse != null) {
            sb.append(spouse.getName());
        }
        return sb.toString();
    }

    private List<Human> getOtherChildren() {
        List<Human> otherChildren = new ArrayList<>(children);
        otherChildren.remove(this);
        return otherChildren;
    }
}
