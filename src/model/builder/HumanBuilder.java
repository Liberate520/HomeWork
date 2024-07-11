package model.builder;

import model.human.Gender;
import model.human.Human;
import model.id_generator.IdGenerator;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private static final IdGenerator idGenerator = new IdGenerator();
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private Human spouse;

    public HumanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public HumanBuilder setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
        return this;
    }

    public HumanBuilder setFather(Human father) {
        this.father = father;
        return this;
    }

    public HumanBuilder setMother(Human mother) {
        this.mother = mother;
        return this;
    }

    public HumanBuilder setSpouse(Human spouse) {
        this.spouse = spouse;
        return this;
    }

    public Human build() {
        int id = idGenerator.generateId();
        Human human = new Human(name, gender, birthDate, deathDate, father, mother);
        human.setId(id);
        human.setSpouse(spouse);
        return human;
    }
}

