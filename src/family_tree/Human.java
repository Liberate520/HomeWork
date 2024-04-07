package family_tree;

import java.util.List;
import java.time.LocalDate;

public class Human {
    String name;
    LocalDate dob, dod;
    Gender gender;
    List<Human> children;
    Human mother, father;

    public Human(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dob;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setDateOfDeath(LocalDate dod) {
        this.dod = dod;
    }

    public LocalDate getDateOfDeath() {
        return dod;
    }

    public Gender getGender() {
        return gender;
    }
}
