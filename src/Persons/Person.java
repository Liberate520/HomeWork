package Persons;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private LocalDate birthday, deathDate;
    private List<Person> children;
    private Person mother, father;
    private Gender gender;

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
    public String  getChildren() {
        String out = "";
        for (Person somePers : children) {
            out += somePers;
        }
        return out;
    }
    public String getName() {
        return this.name;
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

}
