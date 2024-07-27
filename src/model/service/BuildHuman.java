package model.service;

import model.builder.Gender;
import model.builder.Human;

import java.time.LocalDate;

public interface BuildHuman {
    Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother);
    Human createHuman(String name, Gender gender, LocalDate birthDate);
    Human createHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother);
    Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate);
}
