package model;

import java.time.LocalDate;

public class Person extends Node {
    public Person(String name, Gender gender, LocalDate birthDate) {
        super(name, gender, birthDate);
    }

    // Методы и поля для хранения информации о человеке
}
