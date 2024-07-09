package Human;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Human {
    public int id;
    public String name;
    public LocalDate birthDay;
    public LocalDate dayOfDeath;
    public Gender gender;
    public String informationsAboutPerson;

    public Human(String name, LocalDate birthDay, LocalDate dayOfDeath, Gender gender) {
        this.id = -1;
        this.name = name;
        this.birthDay = birthDay;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        this.informationsAboutPerson = (STR."Имя: \{name}. Пол: \{gender}");
    }

    public Human(String name, LocalDate birthDay, Gender gender) {
        this.id = -1;
        this.name = name;
        this.birthDay = birthDay;
        this.dayOfDeath = null;
        this.gender = gender;
        this.informationsAboutPerson = (STR."Имя: \{name}. Пол: \{gender}");
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAndGenderString() {
        return (STR."Имя: \{name}. Пол: \{gender}");
    }

    public void setInformationsAboutPerson(String informationsAboutPerson) {
        this.informationsAboutPerson = informationsAboutPerson;
    }

    @Override
    public String toString() {
        return informationsAboutPerson;
    }

    public Gender getGender() {
        return gender;
    }
}
