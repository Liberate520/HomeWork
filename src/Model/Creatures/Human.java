package Model.Creatures;

import Model.Interface.Creature;
import Formating.MyDate;
import Model.Creatures.Gender.Gender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Human implements Serializable, Creature<Human> {
    private static int lastID = 0;
    private final int ID = lastID++;
    private MyDate dateOfBirth = null, dataOfDeath = null;
    private String name, surname;
    private Gender gender;
    private final ArrayList<Human> children = new ArrayList<>();
    private Human mather = null, father = null, spouse = null;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public MyDate getDataOfDeath() {
        return dataOfDeath;
    }

    public Human getFather() {
        return father;
    }

    public Human getMather() {
        return mather;
    }

    public int getID() {
        return ID;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(MyDate dateOfBirth) {
         this.dateOfBirth = dateOfBirth;
    }

    public void setDataOfDeath(MyDate dataOfDeath) {
        this.dataOfDeath = dataOfDeath;
    }

    public void setFather(Human father) {
        if (!this.equals(father)) {
            this.father = father;

            if (father != null) this.father.addChildren(this);
        }
    }

    public void setMather(Human mather) {
        if (!this.equals(mather)) {
            this.mather = mather;

            if (mather != null) this.mather.addChildren(this);
        }
    }

    public void setSpouse(Human spouse) {
        if (!this.equals(spouse)){
            this.spouse = spouse;

            if (spouse != null){
                this.spouse.spouse = this;

                ArrayList<Human> childrenCopy = new ArrayList<>(this.children);

                for (Human kid: this.spouse.getChildren()){
                    this.addChildren(kid);
                }

                for (Human kid: childrenCopy){
                    this.spouse.addChildren(kid);
                }
            }
        }
    }

    public void addChildren(Human new_kid){
        if (!this.children.contains(new_kid)){

            if (this.gender.equals(Gender.male)) new_kid.father = this;

            else new_kid.mather = this;

            this.children.add(new_kid);

            if (this.spouse != null) this.spouse.addChildren(new_kid);
        }
    }

    public void removeKid(Human kid){
        for (Human currentKid: new ArrayList<>(this.children)){
            if (currentKid.equals(kid)) this.children.remove(kid);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        info.append(String.format("\tID: %d", this.ID));

        info.append(String.format("%n\tName: %s %s", this.name, this.surname));

        if (this.gender != null) info.append(String.format("%n\tGender: %s", this.gender));
        if (this.dateOfBirth != null) info.append(String.format("%n\tData of birth: %s", this.dateOfBirth));
        if (this.dataOfDeath != null) info.append(String.format("%n\tData of death: %s", this.dataOfDeath));
        if (this.spouse != null) info.append(String.format("%n\tSpouse: %s %s", this.spouse.getName(), this.spouse.getSurname()));
        if (this.mather != null) info.append(String.format("%n\tMather: %s %s", this.mather.getName(), this.mather.getSurname()));
        if (this.father != null) info.append(String.format("%n\tFather: %s %s", this.father.getName(), this.father.getSurname()));

        if (!this.children.isEmpty()){
            info.append("\n\tChildren: ");

            for (Human kid: this.children){
                info.append(String.format("%n\t\tID: %d", kid.getID()));

                info.append(String.format("%n\t\tName: %s %s", kid.getName(), kid.getSurname()));

                if (kid.getDateOfBirth() != null)
                    info.append(String.format("%n\t\tData of birth: %s", kid.getDateOfBirth()));

                if (kid.getDataOfDeath() != null)
                    info.append(String.format("%n\t\tData of death: %s", kid.getDataOfDeath()));

                info.append("\n");
            }
        } else {
            info.append("\n");
        }

        return info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Human human = (Human) obj;

        return this.ID == human.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.gender, this.ID);
    }
}
