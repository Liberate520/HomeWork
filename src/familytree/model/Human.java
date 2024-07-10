package familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human extends FamilyMember {
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;

    public Human(String name, LocalDate birthDate, Gender gender) {
        super(name);
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this(name, birthDate, gender);
        this.deathDate = deathDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isAlive() {
        return deathDate == null;
    }

    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }
}