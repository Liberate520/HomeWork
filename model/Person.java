package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private Date birthDate;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, String birthDate, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
        try {
            this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void addChild(Person child) {
        children.add(child);
        if (this.gender == Gender.MALE) {
            child.setFather(this);
        } else if (this.gender == Gender.FEMALE) {
            child.setMother(this);
        }
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        String fatherName = (father != null) ? father.getName() : "no";
        String motherName = (mother != null) ? mother.getName() : "no";
        String childrenNames = (children.isEmpty()) ? "no" : "";
        for (Person child : children) {
            childrenNames += child.getName() + " ";
        }
        return "Имя: " + name + ", Дата рождения: " + new SimpleDateFormat("dd.MM.yyyy").format(birthDate) + ", Пол: " + gender + ", Папа: " + fatherName + ", Мама: " + motherName + ", Дети: " + childrenNames;
    }
}
