package model.builder;

import java.time.LocalDate;

import model.human.Gender;
import model.human.Human;

public class HumanBuilder {
    private int genId;

    public Human build(String name, Gender gender, LocalDate dateOfBirth){
        return new Human(genId++, name, gender, dateOfBirth);
    }

}
