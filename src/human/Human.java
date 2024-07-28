package human;

import familytree.Creature;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Human implements Serializable, Comparable<Human>, Creature {

    private int humanNumber;
    private String name;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Human whoSpouse;
    private LocalDate dateOfMarriage;
    private Gender gender;
    private FamilyStatus familyStatus;
    private ArrayList<Human> amountOfChildren = new ArrayList<>();
    private ArrayList<Human> parents = new ArrayList<>();


    public Human(int humanNumber, String name, LocalDate dateBirth, LocalDate dateDeath, Gender gender, FamilyStatus familyStatus) {
        this.humanNumber = humanNumber;
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.gender = gender;
        this.familyStatus = familyStatus;
    }

    public String getInfo() {
        return String.format("Name: %s, Date of Birt %s",this.name, this.dateBirth);
    }

    public int getHumanNumber() {
        return humanNumber;
    }
    public void setHumanNumber(int humanNumber) {
        this.humanNumber = humanNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }
    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public void setWhoSpouse(Human whoSpouse) {
        this.whoSpouse = whoSpouse;
    }
    public Human getWhoSpouse() {
        return whoSpouse;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {
        return gender;
    }

    public void setDateOfMarriage(LocalDate dateOfMarriage) {
        this.dateOfMarriage = dateOfMarriage;
    }
    public LocalDate getDateOfMarriage() {
        return dateOfMarriage;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }
    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    public ArrayList<Human> getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(ArrayList<Human> amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    public ArrayList<Human> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Human> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "human.Human{" +
                "id=" + humanNumber + '\'' +
                "name='" + name + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", dateDiet='" + dateDeath + '\'' +
                ", whoSpouse=" + (whoSpouse == null ? "There is no married couple.": whoSpouse.getName()) +
                ", dateOfMarriage='" + dateOfMarriage + '\'' +
                ", gender=" + gender +
                ", familyStatus=" + familyStatus +
                '}' + '\n';
    }

    public void addChildren(Human human){
        amountOfChildren.add(human);
    }
    public int howManyYears(LocalDate localDateDeath, LocalDate localDateBirth){
        int howManyYears;
        return howManyYears = localDateDeath.getYear() - localDateBirth.getYear();
    }

    public void addParents(Human human){
        parents.add(human);
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }
}
