package model.builder;

import model.human.Gender;
import model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private Human spouse;

    public Human build() {
        Human human = new Human(name, gender, birthDate, deathDate, father, mother);
        human.setSpouse(spouse);
        return human;
    }
}

