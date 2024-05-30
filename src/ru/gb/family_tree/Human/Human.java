package ru.gb.family_tree.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Human implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lastName;
    private String name;
    private Human mother, father;
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private Integer age;


    public Human(String lastName, String name, Gender gender, LocalDate birthDate) {
        this.lastName =  lastName;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public void setParents(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public void addChild(Human child) {
        this.children.add(child);
        if (this.gender == Gender.Female) {
            child.setMother(this);
        } else {
            child.setFather(this);
        }
    }

    private void setMother(Human mother) {
        this.mother = mother;
    }

    private void setFather(Human father) {
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        if (deathDate == null){
           age = Period.between(birthDate, currentDate).getYears();
        }else {
            age = Period.between(birthDate, deathDate).getYears();
        }
        return age;
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Фамилия: " + lastName  +
                " Имя: " + name +
                " возраст: " + age +
                ", мать: " + (mother != null ? mother.getName() : "Неизвестна") +
                ", отец: " + (father != null ? father.getName() : "Неизвестен") +
                ", дети: " + children.stream().map(Human::getName).collect(Collectors.toList()) +
                ", дата рождения: " + birthDate +
                ", дата смерти: " + (deathDate != null ? deathDate : "Нет") +
                ", пол: " + gender +
                "\n}";
    }

}