package model.builder;

import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;

public abstract class HumanBuilder {

    protected Human human;

    public abstract Human createName(String name);

    public abstract Human createGender(Gender gender);

    public HumanBuilder() {
        createHuman();
    }

    public void createHuman() {
        human = new Human();
    }

    public Human getHuman() {
        return human;
    }

    public HumanBuilder setBirthDate(LocalDate birthDate) {
        human.setBirthDate(birthDate);
        return this;
    }

    public HumanBuilder setDeathDate(LocalDate deathDate) {
        human.setDeathDate(deathDate);
        return this;
    }

    public HumanBuilder addChild(Human child) {
        if (human.getChildren() == null) human.initChildren();
        human.addChild(child);
        return this;
    }

    public HumanBuilder addParent(Human parent) {
        if (human.getParents() == null) human.initParents();
        human.addParent(parent);
        return this;
    }

    public HumanBuilder setSpouse(Human spouse) {
        human.setSpouse(spouse);
        return this;
    }

    public Human build(String name, Gender gender) {
        createName(name);
        createGender(gender);
        return human;
    }
}