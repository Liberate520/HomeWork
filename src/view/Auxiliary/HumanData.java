package view.Auxiliary;

import model.human.Gender;

import java.time.LocalDate;

public class HumanData {
    public String name;
    public LocalDate dateOfBirthday;
    public Gender gender;

    public HumanData(String name, LocalDate dateOfBirthday, Gender gender) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
    }
}
