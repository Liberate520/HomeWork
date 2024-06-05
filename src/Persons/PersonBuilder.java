package Persons;

import Persons.Enums.Gender;

public class PersonBuilder {
    public Person build (String name, Gender gender, String birthDate, String deathDate) {
        return new Person(name, gender,birthDate,deathDate);
    }
    public Person build (String name, Gender gender, String birthDate) {
        return new Person(name, gender,birthDate, "9999-01-01");
    }
    public Person build (String name, Gender gender) {
        return new Person(name, gender, "9999-01-01", "9999-01-01");
    }
}
