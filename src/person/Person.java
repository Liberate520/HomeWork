package person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Person spouse;
    private List<Person> children;
    private List<Person> parents;

    public Person(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
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

    public Gender getGender() {
        return gender;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public List<Person> getParents() {
        return parents;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + (deathDate != null ? deathDate : "N/A") +
                ", gender=" + gender +
                ", spouse=" + (spouse != null ? spouse.getName() : "None") +
                ", children=" + getChildrenNames() +
                ", parents=" + getParentNames() +
                '}';
    }

    private String getChildrenNames() {
        if (children.isEmpty()) return "None";
        StringBuilder names = new StringBuilder();
        for (Person child : children) {
            names.append(child.getName()).append(", ");
        }
        return names.substring(0, names.length() - 2);
    }

    private String getParentNames() {
        if (parents.isEmpty()) return "None";
        StringBuilder names = new StringBuilder();
        for (Person parent : parents) {
            names.append(parent.getName()).append(", ");
        }
        return names.substring(0, names.length() - 2);
    }
}
