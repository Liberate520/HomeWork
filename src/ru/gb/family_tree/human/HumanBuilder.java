package ru.gb.family_tree.human;

public class HumanBuilder {
    private int genId;
    private Human human;
    private int humanAge;
    private String humanName;

    public HumanBuilder setHumanAge(int humanAge){
        this.humanAge = humanAge;
        return this;
    }

    public HumanBuilder setHumanName(String humanName){
        this.humanName = humanName;
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

    private void createAge(){
        human.setAge(humanAge);
    }

    public Human build(){
        createHuman();
        createName();
        createAge();
        nextId();
        return human;
    }
}
