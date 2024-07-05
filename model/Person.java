package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, String birthDate, Gender gender) {
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.birthDate = LocalDate.parse(birthDate, formatter);
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void addChild(Person child) {
        children.add(child);
        if (this.gender == Gender.MALE) {
            child.setFather(this);
        } else if (this.gender == Gender.FEMALE) {
            child.setMother(this);
        }
    }

    @Override
    public String toString() {
        String motherName = mother != null ? mother.getName() : "no";
        String fatherName = father != null ? father.getName() : "no";
        String childrenNames = children.isEmpty() ? "no" : children.toString();

        return "Имя: " + name + ", Дата рождения: " + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", Пол: " + gender + ", Мать: " + motherName + ", Отец: " + fatherName + ", Дети: " + childrenNames;
    }
}
