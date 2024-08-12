package Model.Builders;

import Model.Creature.Gender;
import Model.Creature.OwnInfo;
import Model.Formating.MyDate;

public class OwnInfoBuilder {
    private Integer ID;
    private MyDate dateOfBirth;
    private MyDate dateOfDeath;
    private String name;
    private String surname;
    private Gender gender;

    public OwnInfoBuilder setDateOfDeath(MyDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;

        return this;
    }

    public OwnInfoBuilder setDateOfBirth(MyDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;

        return this;
    }

    public OwnInfoBuilder setID(Integer ID) {
        this.ID = ID;

        return this;
    }

    public OwnInfoBuilder setGender(Gender gender) {
        this.gender = gender;

        return this;
    }

    public OwnInfoBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public OwnInfoBuilder setSurname(String surname) {
        this.surname = surname;

        return this;
    }

    public OwnInfo build(){
        return new OwnInfo(this.ID, this.name, this.surname, this.gender, this.dateOfBirth, this.dateOfDeath);
    }
}
