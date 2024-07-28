package model.builder;

import model.Humans.Gender;
import model.Humans.Human;

import java.time.LocalDate;

public class HumanBuilder{
    private int HumanID;
     

    public Human build(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender) {
        return new Human(HumanID++, name, dateOfBorn, dateOfDeath, gender);
    }
}
