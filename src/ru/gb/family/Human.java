package ru.gb.family;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private Integer id;
    private String name;
    private Gender gender;
    private LocalDate birthday,dateOfDeath;
    private Human father,mother;
    private List<Human> children;
    private Human spouse;


    public Human(String name, LocalDate birthday, LocalDate dateOfDeath, Gender gender) {
        id = +1;
        this.name = name;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.children =new ArrayList<>();

    }

    public void addCParent(Human parent){
        if (parent.gender == Gender.Male){
            this.father = parent;
        }
        else{
            this.mother = parent;
        }

    }

    public void addChildren(Human child) {
        if (child != null) {
            children.add(child);
        }
    }
    public void changedateOfDeath(LocalDate dateDeath){
        if (dateDeath != null){
            this.setDateOfDeath(dateDeath);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // список детей
        for (Human human : children){
            stringBuilder.append(human.name);
            stringBuilder.append(",\t");
        }
        return "\n id=" + id + '\t' +
                "name=" + name +
                "\t birthday(" + birthday +
                ")\t dateOfDeath(" + dateOfDeath +
                ")\t gender=" + gender +
                "\n\t Отец:" + ((!(father == null)) ? father.name : "") +
                "\n\t Мать:" + ((!(mother == null)) ? mother.name : "") +
                "\n\t дети:" + stringBuilder + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(birthday, human.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
}
