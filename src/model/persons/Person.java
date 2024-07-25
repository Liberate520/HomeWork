package model.persons;

import model.familytree.TreeNodes;
import model.persons.person_manager.PersonFormatter;
import model.persons.person_manager.PersonRelations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements TreeNodes<Person> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay, deathDay;
    private Person mother, father, spouse;
    private List<Person> children;
    private PersonRelations personsRelations;

    public Person(String name, Gender gender, LocalDate birthDay, LocalDate deathDay, Person mother, Person father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        this.personsRelations = new PersonRelations(this);
    }

    public Person(String name, Gender gender, LocalDate birthDay) {
        this(name, gender, birthDay, null, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(LocalDate deathDay) {
        this.deathDay = deathDay;
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

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void addChild(Person child) {
        personsRelations.addChild(child);
    }

    @Override
    public List<Person> getParents() {
        return personsRelations.getParents();
    }

    public void addParent(Person parent) {
        personsRelations.addParent(parent);
    }

    public int getAge() {
        if (deathDay == null) {
            return LocalDate.now().getYear() - birthDay.getYear();
        } else {
            return deathDay.getYear() - birthDay.getYear();
        }
    }

    @Override
    public String toString() {
        return new PersonFormatter(this).formatFullPerson();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person person))
            return false;
        return person.getId() == getId();
    }

}