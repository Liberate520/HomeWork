package familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private FullName fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Person> parents;
    private List<Person> children;


    public Person(String familyName, String firstName, String fatherName, Gender gender, LocalDate dateOfBirth) {
        this.fullName = new FullName(familyName, firstName, fatherName);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

        public Person(String familyName, String firstName, String fatherName, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.fullName = new FullName(familyName, firstName, fatherName);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public FullName getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return " " +
                "ФИО:" + fullName +
                " , пол:" + gender +
                " , дата рождения:" + dateOfBirth +
                (dateOfDeath != null ? " , дата смерти:" + dateOfDeath : "") +
                ' ';
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}