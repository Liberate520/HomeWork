import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {

    private long id;
    private String name;
    private String lastName;
    private LocalDate  dateOfBirth, dateOfDeath;
    private List<Human> children;
    private Human father, mother;
    private Gender gender;

    public Human (String name, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender, Human mother, Human father){
        id = -1;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        if (dateOfDeath != null) { // заимствовал. не думал что так можно
            this.dateOfDeath = dateOfDeath;
        }
        if (mother != null) {
            this.mother = mother;
        }
        if (father != null) {
            this.father = father;
        }
        children = new ArrayList<>(); // заимствовал
    }
    public Human (String name, String lastName, LocalDate dateOfBirth, Gender gender){
        this(name, lastName, dateOfBirth, null, gender, null, null);
    }
    public Human (String name, String lastName, LocalDate dateOfBirth, Gender gender, Human mother, Human father){
        this(name, lastName, dateOfBirth, null, gender, mother, father);
    }
    public Human (String name, String lastName, LocalDate dateOfBirth,LocalDate dateOfDeath, Gender gender){
        this(name, lastName, dateOfBirth, dateOfDeath, gender, null, null);
    }
    // get\set
    public void setID(long id){
        this.id = id;
    }
    public String  getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String  getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public LocalDate  getDateOfBirth() {
        return dateOfBirth;
    }
    public boolean setDateOfBirth(LocalDate dateOfBirth){
        if(dateOfBirth.isAfter(this.dateOfDeath)){
            this.dateOfBirth=dateOfBirth;
            return true;
        } else {
            return false;
        }
    }
    public LocalDate  getDateOfDeath() {
        return dateOfDeath;
    }
    public boolean setDateOfDeath(LocalDate DateOfDeath){
        if(this.dateOfBirth.isAfter(dateOfDeath)){
            this.dateOfDeath=dateOfDeath;
            return true;
        } else {
            return false;
        }
    }
    public Gender  getGender() {
        return gender;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }
    public String getStringListChildren() {
        return children.toString(); // не уверен что будет работать.
    }
    public boolean addChildToList(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean removeChildFromList(Human child){
        //на случай если добавлен по ошибке
        if (!children.contains(child)){
            children.remove(child);
            return true;
        }
        return  false;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append("\t| Имя: ");
        sb.append(name);
        sb.append("\t| Фамилия: ");
        sb.append(lastName);
        sb.append("\t| Родители: ");
        if( getFather() != null ) {
            sb.append(getFather().getName());
        } else {
            sb.append("неизвестно");
        }
        if( getMother() != null ) {
            sb.append(", " + getMother().getName());
        }else {
            sb.append(", неизвестно");
        }
        sb.append("\t| дата рождения: ");
        sb.append(getDateOfBirth());
        if(getDateOfDeath()!=null) {
            sb.append("\t| дата смерти: ");
            sb.append(getDateOfDeath());
        }

        return sb.toString();
    }
}
