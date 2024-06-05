package Persons;

import Persons.Enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Person implements Serializable, Iterator<String>{
    private String name;
    private LocalDate birthday, deathDate;
    private List<Person> children;
    private Person mother, father;
    private Gender gender;
    // для итератора
    int index;

    //конструкторы
    public Person(String name, Gender gender, String birthDate, String deathDate)  {
        this.name = name;
        this.gender = gender;
        this.birthday = LocalDate.parse(birthDate);
        this.deathDate = LocalDate.parse(deathDate);
        this.children = new ArrayList<>();
    }
    public Person(String name, Gender gender, String birthDate)  {
        this(name, gender, birthDate, "9999-01-01");
    }
    public Person(String name, Gender gender) {
        this(name, gender,"9999-01-01","9999-01-01");
    }


    //методы
    public void addChildren(Person child) {
        this.children.add(child);
    }
    public void addParent(Person parent) {
        if (parent.gender == Gender.male)
            this.father = parent;
        else
            this.mother = parent;
    }
    public String getParent() {
        return  "Father: " + father + "\nMother: " + mother;
    }
    public String getChildren() {
        String out = "";
        for (Person somePers : children) {
            out += somePers;
        }
        return out;
    }
    public String getName() {
        return this.name;
    }
    public String getDates() {
        String out = "Birthday: " + birthday;
        if (deathDate.getYear() != 9999)
            return out += "\nDeath Date: " + deathDate;
        return out;
    }
    public LocalDate getBirthday() {
        return this.birthday;
    }

    @Override
    public String toString() {
        String out = "\n\nname: " + name +
                "\ngender: " + gender;
        if (this.birthday.getYear() != 9999)
            out += "\ndate of birth: " + birthday;
        if (this.deathDate.getYear() != 9999)
            out += "\ndate of death: " + deathDate;
        out += getCloseRelations();
        return out;
    }

    private String getCloseRelations() {
        String out = "";
        if(this.father != null)
            out = "\nFather: \nname: " + father.name +
                "\ngender: "+ father.gender;
        if (mother != null)
            out += "\nMother: \nname: " + mother.name +
                "\ngender: " + mother.gender;
        for (Person child : children) {
            out += "\nChild: \nname: " + child.name +
                "\ngender: " + child.gender +
                "\nbirthday: " + child.birthday;
            if (child.deathDate.getYear() != 9999)
                out += "\ndate of death: " + child.deathDate;
        }
        return out;
    }

    @Override
    public boolean hasNext() {
        return index++ < 5;
    }
    @Override
    public String next() {
        switch (index) {
            case 0:
                return getName();
            case 1:
                return getDates();
            case 2:
                return getChildren();
            case 3:
                return getParent();
            default:
                return String.valueOf(gender);
        }
    }
}
