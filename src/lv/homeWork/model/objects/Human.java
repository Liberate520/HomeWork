package lv.homeWork.model.objects;

import lv.homeWork.model.Gender;
import lv.homeWork.model.interfaces.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

public class Human implements Serializable, TreeNode<Human> {

    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> childrens;
    private Human married;
    private int passportID;
    private long personID;
    private int generation;


    public Human(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        childrens = new ArrayList<>();
        this.passportID = passportID;
        this.personID = -1;
        this.generation = -1;
        if(father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        setGeneration();

    }

    public Human(Integer passportID, String name, Gender gender, LocalDate dateOfBirth){
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        parents = new ArrayList<>();
        childrens = new ArrayList<>();
        this.married = null;
        this.passportID = passportID;
        this.personID = -1;
        this.generation = -1;
        setGeneration();
    }

    public Human(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, Human mother, Human father ){
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        parents = new ArrayList<>();
        childrens = new ArrayList<>();
        this.married = null;
        this.passportID = passportID;
        this.personID = -1;
        this.generation = -1;
        if(father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        setGeneration();
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildrens() {
        return childrens;
    }



    public void addChild(Human child) {
        if (child != null) {
            childrens.add(child);
            child.addParent(this);
            child.setGeneration();
        }
    }

    private void addParent(Human parent) {
        if (parent != null) {
            parents.add(parent);
        }
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getHumanAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    public void setMarried(Human spouse) {
        this.married = spouse;
        if (spouse != null && spouse.getMarried() != this) {
            spouse.setMarried(this);
        }
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void changeGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Human getMarried() {
        return married;
    }

    public long getPassportID() {
        return passportID;
    }

    public void setPassportID(int passportID) {
        this.passportID = passportID;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration() {
        if (parents.isEmpty()) {
            this.generation = 0;
        } else {
            int maxParentGeneration = 0;
            for (Human parent : parents) {
                if (parent.getGeneration() > maxParentGeneration) {
                    maxParentGeneration = parent.getGeneration();
                }
            }
            this.generation = maxParentGeneration + 1;
        }
        for (Human child : childrens) {
            child.setGeneration();
        }
    }


    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Generation: ");
        sb.append(getGeneration());
        sb.append(" / Passport ID: ");
        sb.append(passportID);
        sb.append(" / Name: ");
        sb.append(name);
        sb.append(" / Gender: ");
        sb.append(getGender());
        sb.append(" / Age ");
        sb.append(getHumanAge());
        sb.append(" / Mother: ");
        Human mother = getMother();
        sb.append(mother != null ? mother.getName() : "Unknown");
        sb.append(" / Father: ");
        Human father = getFather();
        sb.append(father != null ? father.getName() : "Unknown");
        return sb.toString();
    }



}
