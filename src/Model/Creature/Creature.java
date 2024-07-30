package Model.Creature;

import Model.Formating.MyDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Creature implements Serializable, Entity {
    private final int ID;
    private MyDate dateOfBirth = null, dataOfDeath = null;
    private String name, surname;
    private Gender gender;
    private final ArrayList<Entity> children = new ArrayList<>();
    private Entity mather = null, father = null, spouse = null;

    public Creature(String name, String surname, Gender gender, int ID){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Entity> getChildren() {
        return children;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public MyDate getDataOfDeath() {
        return dataOfDeath;
    }

    public Entity getFather() {
        return father;
    }

    public Entity getMather() {
        return mather;
    }

    public int getID() {
        return ID;
    }

    public Gender getGender() {
        return gender;
    }

    public Entity getSpouse() {
        return spouse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(MyDate dateOfBirth) {
         this.dateOfBirth = dateOfBirth;
    }

    public void setDataOfDeath(MyDate dataOfDeath) {
        this.dataOfDeath = dataOfDeath;
    }

    public void setFather(Entity father) {
        if (!this.equals(father)) {
            this.father = father;
        }
    }

    public void setMather(Entity mather) {
        if (!this.equals(mather)) {
            this.mather = mather;
        }
    }

    public void setSpouse(Entity spouse) {
        if (!this.equals(spouse)){
            this.spouse = spouse;
        }
    }

    public void addKid(Entity new_kid){
        if (!this.children.contains(new_kid)){

            if (this.gender.equals(Gender.male)) new_kid.setFather(this);

            else new_kid.setMather(this);

            this.children.add(new_kid);

            if (this.spouse != null) this.spouse.addKid(new_kid);
        }
    }

    public void addChildren(ArrayList<Entity> children){
        for (Entity kid: children) this.addKid(kid);
    }

    public void removeKid(Entity kid){
        for (Entity currentKid: new ArrayList<>(this.children)){
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

            for (Entity kid: this.children){
                info.append(String.format("%n\t\tID: %d", kid.getID()));

                info.append(String.format("%n\t\tName: %s %s", kid.getName(), kid.getSurname()));

                if (kid.getGender() != null) info.append(String.format("%n\t\tGander: %s", kid.getGender()));

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

        Creature creature = (Creature) obj;

        return this.ID == creature.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.gender, this.ID);
    }
}
