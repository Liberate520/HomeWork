package lv.homeWork.model;

import lv.homeWork.model.Gender;
import lv.homeWork.model.objects.Human;

import java.time.LocalDate;

public class HumanFactory {

    public Human createHuman(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father) {
        return new Human(passportID, name, gender, dateOfBirth, dateOfDeath, mother, father);
    }

    public Human createHuman(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, Human mother, Human father) {
        return new Human(passportID, name, gender, dateOfBirth, mother, father);
    }

    public Human createHuman(Integer passportID, String name, Gender gender, LocalDate dateOfBirth) {
        return new Human(passportID, name, gender, dateOfBirth);
    }
}
