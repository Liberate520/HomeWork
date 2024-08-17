package familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

public class Person implements Identifiable, Serializable {
    private static final long serialVersionUID = 1L;
    private FullName fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Person> parents;
    private List<Person> children;
    private Person spouse;

    public Person(String familyName, String firstName, String fatherName, Gender gender, LocalDate dateOfBirth) {
        this.fullName = new FullName(familyName, firstName, fatherName);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.spouse = null;
    }

    @Override
    public FullName getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
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

    @Override
    public List<Person> getChildren() {
        return children;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public void addParent(Identifiable parent) {
        this.parents.add((Person) parent);
    }

    @Override
    public void addChild(Identifiable child) {
        this.children.add((Person)child);
    }

    // Метод для вычисления возраста
    public int getAge() {
        if (dateOfDeath != null) {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        } else {
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ФИО: ").append(fullName)
                .append(", пол: ").append(gender)
                .append(", дата рождения: ").append(dateOfBirth)
                .append(", возраст: ").append(getAge());

        if (dateOfDeath != null) {
            sb.append(", дата смерти: ").append(dateOfDeath);
        }

        if (spouse != null) {
            sb.append(", супруг/супруга: ").append(spouse.getFullName());
        }

        if (!children.isEmpty()) {
            sb.append(", дети: ");
            for (Person child : children) {
                sb.append(child.getFullName()).append("; ");
            }
        }

        return sb.toString();
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}