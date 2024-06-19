package lv.homeWork.model.objects;

import lv.homeWork.model.Gender;
import lv.homeWork.model.ObjectRelations;
import lv.homeWork.model.AgeCalculator;
import lv.homeWork.model.GenerationCalculator;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable, TreeNode<Human> {

    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private ObjectRelations objectRelations;
    private int passportID;
    private long personID;
    private int generation;

    public Human(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.objectRelations = new ObjectRelations();
        this.passportID = passportID;
        this.personID = -1;
        this.generation = -1;
        if (father != null) {
            objectRelations.addParent(father);
        }
        if (mother != null) {
            objectRelations.addParent(mother);
        }
        GenerationCalculator.setGeneration(this);
    }

    public Human(Integer passportID, String name, Gender gender, LocalDate dateOfBirth) {
        this(passportID, name, gender, dateOfBirth, null, null);
    }

    public Human(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, Human mother, Human father) {
        this(passportID, name, gender, dateOfBirth, null, mother, father);
    }

    public ObjectRelations getObjectRelations() {
        return objectRelations;
    }

    public int getHumanAge() {
        return AgeCalculator.calculateAge(dateOfBirth, dateOfDeath);
    }

    @Override
    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public void changeGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public long getPassportID() {
        return passportID;
    }

    public void setPassportID(int passportID) {
        this.passportID = passportID;
    }

    @Override
    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    @Override
    public Human getMarried() {
        return objectRelations.getMarried();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Generation: ").append(getGeneration());
        sb.append(" / Passport ID: ").append(passportID);
        sb.append(" / Name: ").append(name);
        sb.append(" / Gender: ").append(getGender());
        sb.append(" / Age: ").append(getHumanAge());
        sb.append(" / Mother: ");
        Human mother = objectRelations.getMother();
        sb.append(mother != null ? mother.getName() : "Unknown");
        sb.append(" / Father: ");
        Human father = objectRelations.getFather();
        sb.append(father != null ? father.getName() : "Unknown");
        return sb.toString();
    }
}
