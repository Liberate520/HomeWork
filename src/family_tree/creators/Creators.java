package family_tree.creators;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public abstract class Creators implements Serializable {
    private final int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;

    public Creators(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.id = IDGenerator.generateID();
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Creators(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null);
    }

    public Creators(){
        this(null, null, null, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Creators human)) {
            return false;
        }
        return human.getId() == getId();
    }
}
