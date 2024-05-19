import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private String sname;
    private LocalDate  dateOfBirth, dateOfDeath;
    private List<Human> children;
    private Human father, mother;
    private Gender gender;
    public Human (String name, String sname, LocalDate dateOfBirth, Gender gender){
        this.name = name;
        this.sname = sname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public Human (String name, String sname, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender){
        this.name = name;
        this.sname = sname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
    }
    // get\set
    public String  getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String  getSname() {
        return sname;
    }
    public void setSname(String sname){
        this.sname = sname;
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
    public void addToListChildren(Human children){
        this.children.add(children);
    }
    public boolean removeFromListChildren(){
        //заглушка
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
}
