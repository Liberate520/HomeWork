package ru.gb.family_tree.model.builder;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private Human human;
    private LocalDate deathDate;
    private Human father, mother;

    public HumanBuilder(){
        createHuman();
    }

    private void createHuman(){
        human = new Human();
    }

    public HumanBuilder setDeathDate(LocalDate deathDate){
        this.deathDate = deathDate;
        return this;
    }

    public HumanBuilder setFather(Human father){
        this.father = father;
        return this;
    }

    public HumanBuilder setMother(Human mother){
        this.mother = mother;
        return this;
    }

    public Human build(String name, Gender gender, LocalDate birthDate){
        human.setName(name);
        human.setGender(gender);
        human.setBirthDate(birthDate);
        human.setFather(father);
        human.setMother(mother);
        human.setDeathDate(deathDate);

        clear();
        return human;
    }

    private void clear(){
        deathDate = null;
        mother = null;
        father = null;
    }
}
