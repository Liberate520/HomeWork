package ru.gb.family_tree.human;

import java.time.LocalDate;

public class HumanBuilder {
    private int genId;
    private Human human;
    private String humanName;
    private LocalDate humanBirthDate;

    public HumanBuilder setHumanName(String humanName){
        this.humanName = humanName;
        return this;
    }

    public HumanBuilder setHumanBirthDate(LocalDate humanBirthDate){
        this.humanBirthDate = humanBirthDate;
        return this;
    }

    private void createHuman(){
        human = new Human();
    }

    private void nextId(){
        human.setId(genId++);
    }

    private void createName(){
        human.setName(humanName);
    }

    private void createBirthDate(){human.setBirthDate(humanBirthDate);}

    public Human build(){
        createHuman();
        createName();
        createBirthDate();
        nextId();
        return human;
    }
}
