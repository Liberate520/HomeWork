package familytree.factory;

import familytree.model.FullName;
import familytree.model.Person;

import java.time.LocalDate;

public class PersonFactory {
    public Person createPerson(String familyName, String firstName, String fatherName, Person.Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        return new Person(new FullName(familyName, firstName, fatherName), gender, dateOfBirth, dateOfDeath);
    }
}