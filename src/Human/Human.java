package Human;

import Formating.MyDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Human implements Serializable{
    private static int lastID = 0;
    private final int ID = lastID;
    private MyDate dateOfBirth;
    private MyDate dataOfDeath;
    private final String name, surname;
    private final Gender gender;
    private final ArrayList<Human> children = new ArrayList<>();
    private Human mather = null, father = null, spouse = null;

    public Human(String name, String surname, Gender gender, MyDate dateOfBirth, MyDate dataOfDeath){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dataOfDeath = dataOfDeath;
        lastID++;
    }

    public Human(String name, String surname, Gender gender, MyDate dateOfBirth){
        this(name, surname, gender, dateOfBirth, null);
    }

    public Human(String name, String surname, Gender gender){
        this(name, surname, gender, null, null);
    }

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

    public void setDateOfBirth(MyDate dateOfBirth) {
         this.dateOfBirth = dateOfBirth;
    }

    public void setDataOfDeath(MyDate dataOfDeath) {
        this.dataOfDeath = dataOfDeath;
    }

    public void setFather(Human father) {
        if (!this.equals(father)) {
            this.father = father;
            this.father.addChildren(this);
        }
    }

    public void setMather(Human mather) {
        if (!this.equals(mather)) {
            this.mather = mather;
            this.mather.addChildren(this);
        }
    }

    public void setSpouse(Human spouse) {
        if (!this.equals(spouse)){
            this.spouse = spouse;

            this.spouse.spouse = this;

            for (Human kid: this.children){
                this.spouse.addChildren(kid);
            }

            for (Human kid: this.spouse.getChildren()){
                this.addChildren(kid);
            }
        }
    }

    public void addChildren(Human new_kid){
        if (!this.children.contains(new_kid)){
            if (this.gender.equals(Gender.Male)){
                new_kid.father = this;
            } else {
                new_kid.mather = this;
            }

            this.children.add(new_kid);

            if (this.spouse != null) this.spouse.addChildren(new_kid);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        info.append(String.format("%nID: %d", this.ID));
        info.append(String.format("%nName: %s %s", this.name, this.surname));
        info.append(String.format("%nData of birth: %s", this.dateOfBirth));
        if (this.dataOfDeath != null) info.append(String.format("%nData of death: %s", this.dataOfDeath));
        if (this.spouse != null) info.append(String.format("%nSpouse: %s %s", this.spouse.getName(), this.spouse.getSurname()));
        if (this.mather != null) info.append(String.format("%nMather: %s %s", this.mather.getName(), this.mather.getSurname()));
        if (this.father != null) info.append(String.format("%nFather: %s %s", this.father.getName(), this.father.getSurname()));

        if (!this.children.isEmpty()){
            info.append("\nChildren: ");

            for (Human kid: this.children){
                info.append(String.format("%n\tID: %d", kid.getID()));
                info.append(String.format("%n\tName: %s %s", kid.getName(), kid.getSurname()));
                info.append(String.format("%n\tData of birth: %s", kid.getDateOfBirth()));
                if (kid.getDataOfDeath() != null) info.append(String.format("%n\tData of death: %s", kid.getDataOfDeath()));
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
