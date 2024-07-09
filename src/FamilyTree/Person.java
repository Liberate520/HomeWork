package FamilyTree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private Date deathDate;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, String surname, Date birthDate, Date deathDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (Born: " + birthDate + ", Died: " + deathDate + ")";
    }
}
