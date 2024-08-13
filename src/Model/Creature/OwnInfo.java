package Model.Creature;

import Model.Formating.MyDate;

public class OwnInfo {
    private final Integer ID;
    private final MyDate dateOfBirth;
    private final MyDate dateOfDeath;
    private final String name;
    private final String surname;
    private final Gender gender;

    public OwnInfo(Integer ID, String name, String surname, Gender gender, MyDate dateOfBirth, MyDate dateOfDeath) {
        this.ID = ID;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.surname = surname;
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getID() {
        return ID;
    }

    public String getSurname() {
        return surname;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public MyDate getDateOfDeath() {
        return dateOfDeath;
    }
}

