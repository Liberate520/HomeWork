package model.service;

import model.builder.Gender;
import model.builder.Human;

import java.time.LocalDate;

public class ServiceBuildHuman implements BuildHuman {
    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        return new Human(name, gender, birthDate, deathDate);
    }

    @Override
    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        return new Human(name, gender, birthDate, deathDate, father, mother);
    }

    @Override
    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        return new Human(name, gender, birthDate);
    }

    @Override
    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        return new Human(name, gender, birthDate, father, mother);
    }
}
