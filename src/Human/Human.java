package Human;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Human {
    private int id = -1;
    private final String firstName;
    private String lastName;
    private Human mother, father;
    private List<Human> childrens;
    private final Gender gender;
    private final LocalDate dob;
    private LocalDate dod = null;
    private Human spouse;

    public Human(String firstName, String lastName, Gender gender, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.childrens = new LinkedList<>();
    }
    public Human(String firstName, String lastName, Gender gender, LocalDate dob, LocalDate dod){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.dod = dod;
        this.childrens = new LinkedList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return childrens;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setChildren(Human children) {
        if (!childrens.contains(children)) {
            this.childrens.add(children);
            if (this.gender.equals(Gender.male) && children.father == null) {
                children.father = this;
            } else if (this.gender.equals(Gender.female) && children.mother == null) {
                children.mother = this;
            }
        }
        }


    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public void addParent(Human parent) {
        if (parent.gender.equals(Gender.female)) {
            this.mother = parent;
            parent.setChildren(this);
        }
        else if (parent.gender.equals(Gender.male)) {
            this.father = parent;
            parent.setChildren(this);
        }
    }

    @Override
    public String toString() {
        return this.getInfo();
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ");
        stringBuilder.append(id);
        stringBuilder.append(", Name: ");
        stringBuilder.append(firstName);
        stringBuilder.append(", Last Name: ");
        stringBuilder.append(lastName);
        stringBuilder.append(", Age: ");
        if (dod != null){
            stringBuilder.append(ChronoUnit.YEARS.between(dob, dod));
        }
        else{
            stringBuilder.append(ChronoUnit.YEARS.between(dob, LocalDate.now()));
        }
        stringBuilder.append(", Father: ");
        if (father != null) stringBuilder.append(father.firstName);
        else stringBuilder.append("N/D");
        stringBuilder.append(", Mother: ");
        if (mother != null) stringBuilder.append(mother.firstName);
        else stringBuilder.append("N/D");
        stringBuilder.append(", Spouse: ");
        if (spouse != null) stringBuilder.append(spouse.firstName);
        else stringBuilder.append("N/D");
        return stringBuilder.toString();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }
    public void setWending(Human spouse){
        if (this.spouse == null && spouse.spouse == null){
            this.setSpouse(spouse);
            spouse.setSpouse(this);
        }
    }
}
