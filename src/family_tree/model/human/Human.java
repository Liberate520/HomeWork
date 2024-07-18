package family_tree.model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, Person {

    private static int idCounter = 0;
    private final int id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Person father, mother;
    private List<Person> children;

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender,
                 Human father, Human mother, List<Person> children) {
        this.id = ++idCounter;
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = children == null ? new ArrayList<>() : children;
    }

    public static void resetIdCounter(int newCounter) {
        idCounter = newCounter;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
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

    @Override
    public int compareTo(Human anotherHuman) {
        return this.name.compareTo(anotherHuman.name);
    }
}
