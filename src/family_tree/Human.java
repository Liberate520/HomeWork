package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int idCounter = 0;

    private final int id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;


    public Human(String name, LocalDate dob, LocalDate dod, Gender gender,
                 Human father, Human mother, List<Human> children) {
        this.id = ++idCounter;
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = children;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Имя: " + name + ", дата рождения: " + dob +
                (dod != null ? ", дата смерти: " + dod : "") +
                (gender != null ? ", пол: " + gender : "") +
                (father != null ? ", отец: " + father.getName() : "") +
                (mother != null ? ", мать: " + mother.getName() : "") +
                (children != null && !children.isEmpty() ? ", дети: " + children.size() : "");
    }
}
