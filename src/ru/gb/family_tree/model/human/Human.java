package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.ElementFamilyTree;

import java.time.LocalDate;
import java.time.Period;

public class Human implements ElementFamilyTree<Human> {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String fatherName;
    private String motherName;

    public Human(long id, String name, LocalDate dateOfBirth, Gender gender, String fatherName, String motherName) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.fatherName = fatherName;
        this.motherName = motherName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Human other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public LocalDate getBirthDate() {
        return this.dateOfBirth;
    }

    @Override
    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public String getChildrenInfo() {
        // Реализуйте логику получения информации о детях, если это необходимо.
        // Пока возвращаем пустую строку или null.
        return "";
    }
}
