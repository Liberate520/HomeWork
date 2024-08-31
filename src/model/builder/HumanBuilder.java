package model.builder;

import model.human.Gender;
import model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private int maxId;
    private Human human;

    public Human build(String name, Gender gender, LocalDate birthDate) {
        human = new Human(maxId++, name, gender, birthDate);
        return human;
    }
    public Human build(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        human = new Human(maxId++, name, gender, birthDate, mother, father);
        return human;
    }
}
