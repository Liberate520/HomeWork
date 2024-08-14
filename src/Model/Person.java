package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person> {
    private static int idCounter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Person> children;
    private Person mother;
    private Person father;

    // Определение enum для пола
    public enum Gender {
        МУЖЧИНА, ЖЕНЩИНА;
    }

    public Person(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this(firstName, lastName, birthDate, null, gender);
        this.id = idCounter++;
    }

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Имя: " + firstName + " " + lastName + ", Дата рождения: " + birthDate +
                (deathDate != null ? ", Дата смерти: " + deathDate : "") + ", Пол: " + gender +
                (mother != null ? ", Мать: " + mother.getFirstName() + " " + mother.getLastName() : "") +
                (father != null ? ", Отец: " + father.getFirstName() + " " + father.getLastName() : "");
    }

    @Override
    public int compareTo(Person other) {
        return this.firstName.compareTo(other.firstName);
    }
}