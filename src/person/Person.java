package person;

import familytree.HasBirthDate;
import familytree.HasName;
import familytree.HasRelations;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, HasName, HasBirthDate, HasRelations<Person> {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }

    @Override
    public List<Person> getParents() {
        return parents;
    }

    public void addChild(Person child) {
        this.children.add(child);
        child.parents.add(this);
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
        parent.children.add(this);
    }

    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }

    @Override
    public String toString() {
        return name + ", " + getAge() + " years old, " + gender;
    }
}
