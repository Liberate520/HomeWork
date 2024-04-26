package model.human;

import java.time.LocalDate;

public class HumanBuilder {

    private Human human;

    public HumanBuilder() {
        createHuman();
    }

    void createHuman() {
        human = new Human();
    }

    public HumanBuilder setName(String name) {
        human.setName(name);
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        human.setGender(gender);
        return this;
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

    public Human build() {
        return human;
    }
}