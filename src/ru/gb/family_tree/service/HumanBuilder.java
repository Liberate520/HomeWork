package ru.gb.family_tree.service;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public class HumanBuilder {
    //private int humanId;
    private Human human;
    //private int studentAge;
    private String humanName;
    private Gender humanGender;
    private LocalDate humanBirthDay;
    private LocalDate humanDeathDate;
    private Human humanFather;
    private Human humanMother;
    private Human humanSpouse;
    //private List<Human> humanChildren;

    public HumanBuilder setHumanName(String humanName) {
        this.humanName = humanName;
        return this;
    }

    public HumanBuilder setHumanGender(Gender humanGender) {
        this.humanGender = humanGender;
        return this;
    }
    public HumanBuilder setHumanBirthDay(LocalDate humanBirthDay) {
        this.humanBirthDay = humanBirthDay;
        return this;
    }
    public HumanBuilder setHumanDeathDate(LocalDate humanDeathDate) {
        this.humanDeathDate = humanDeathDate;
        return this;
    }
    public HumanBuilder setHumanFather (Human humanFather) {
        this.humanFather = humanFather;
        return this;

    }
    public HumanBuilder setHumanMother (Human humanMother) {
        this.humanMother = humanMother;
        return this;
    }
    public HumanBuilder setHumanSpouse (Human humanSpouse) {
        this.humanSpouse = humanSpouse;
        return this;
    }

    /*
    private void createStudent() {
        human = new Student();
    }

     */

    /*
    private void nextId() {
        human.setId(humanId++);
    }

     */

    /*
    private void createName() {
        human.setName(humanName);
    }

    private void createAge() {
        human.setAge(studentAge);
    }

     */

    /*
    public Student build() {
        createStudent();
        createName();
        createAge();
        nextId();
        return human;
    }

     */
}
