package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements FamilyMember, Serializable, Comparable<Person> {
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
//        this.id = idCounter++;
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
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }
    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public LocalDate getDeathDate() {
        return deathDate;
    }
    @Override
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    @Override
    public Gender getGender() {
        return gender;
    }
    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Override
    public List<Person> getChildren() {
        return children;
    }

    public void addChild(FamilyMember child) {
        this.children.add((Person) child);
    }
    @Override
    public Person getMother() {
        return mother;
    }
    @Override
    public void setMother(FamilyMember mother) {
        this.mother = (Person) mother;
    }
    @Override
    public Person getFather() {
        return father;
    }
    @Override
    public void setFather(FamilyMember father) {
        this.father = (Person) father;
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