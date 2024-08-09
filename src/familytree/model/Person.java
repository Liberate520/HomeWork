package familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements TreeMember, Serializable {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
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
    public Gender getGender() {
        return gender;
    }

    @Override
    public Person getFather() {
        return father;
    }

    @Override
    public Person getMother() {
        return mother;
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }

    @Override
    public void setFather(TreeMember father) {
        if (father instanceof Person) {
            this.father = (Person) father;
        }
    }

    @Override
    public void setMother(TreeMember mother) {
        if (mother instanceof Person) {
            this.mother = (Person) mother;
        }
    }

    @Override
    public void addChild(TreeMember child) {
        if (child instanceof Person) {
            Person personChild = (Person) child;
            children.add(personChild);
            if (this.gender == Gender.MALE) {
                personChild.setFather(this);
            } else {
                personChild.setMother(this);
            }
        }
    }
}