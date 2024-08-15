package person;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;

    public Person(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Birth Date: " + birthDate +
                ", Death Date: " + deathDate +
                ", Gender: " + gender;
    }
}
