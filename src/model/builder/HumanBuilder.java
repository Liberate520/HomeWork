package model.builder;

import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    public Human build(String name, Gender gender, LocalDate birthDate) {
        return new Human(name, gender, birthDate);
    }
}