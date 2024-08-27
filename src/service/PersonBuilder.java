package service;

import person.Gender;
import person.Person;

import java.time.LocalDate;

public class PersonBuilder {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PersonBuilder setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
        return this;
    }

    public PersonBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Person build() {
        return new Person(name, birthDate, deathDate, gender);
    }
}
