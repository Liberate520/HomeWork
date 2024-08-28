package ru.gb.family_tree.model.human;

import java.time.LocalDate;

public class HumanBuilder {
    private int genId;
    private Human human;
    private String humanName;
    private Gender humanGender;
    private LocalDate humanBirthDate;
    private LocalDate humanDeathDate;

    public HumanBuilder setHumanName(String humanName){
        this.humanName = humanName;
        return this;
    }

    public HumanBuilder setHumanGender(Gender humanGender){
        this.humanGender = humanGender;
        return this;
    }

    public HumanBuilder setHumanBirthDate(LocalDate humanBirthDate){
        this.humanBirthDate = humanBirthDate;
        return this;
    }

    public HumanBuilder setHumanDeathDate(LocalDate humanDeathDate){
        this.humanDeathDate = humanDeathDate;
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

    private void createGender(){
        human.setGender(humanGender);
    }

    private void createBirthDate(){human.setBirthDate(humanBirthDate);}

    private void createDeathDate(){human.setDeathDate(humanDeathDate);}

    public Human build(){
        createHuman();
        createName();
        createGender();
        createBirthDate();
        createDeathDate();
        nextId();
        return human;
    }

    public void clear(){
        humanName = null;
        humanBirthDate = null;
        humanDeathDate = null;
    }
}
