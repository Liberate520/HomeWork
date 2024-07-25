package model.builder;

import model.persons.Gender;
import model.persons.Person;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonBuilder implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Person mother;
    private Person father;
    private Person spouse;

    public Person build() {
        Person person = new Person(name, gender, birthDay, deathDay, mother, father);
        person.setSpouse(spouse);
        return person;
    }
}
