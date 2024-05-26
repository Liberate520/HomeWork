package OOP.SemDZ.homeWork;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human implements Serializable {
    private String name;
    private int id = 0;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate death = null;
    private Human father = null;
    private Human mather = null;
    private Human spouse = null;

    public Human (String name, Gender gender, LocalDate birthDay, LocalDate death, Human father, Human mather){
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.death = death;
        this.father = father;
        this.mather = mather;
    }
    
    public Human (String name, Gender gender, LocalDate birthDay, Human father, Human mather){
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.father = father;
        this.mather = mather;
    }
     
    public Human (String name, Gender gender, LocalDate birthDay){
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public Human getFather(){
        return this.father;
    }

    public Human getMather(){
        return this.mather;
    }

    public int getAge(){
        if (death != null){
            return (Period.between(birthDay, death)).getYears();
        }
        else return (Period.between(birthDay, LocalDate.now())).getYears();
    }

    public String getName(){ return name;}
    public Gender getGender(){ return gender;}
    public LocalDate getBirthDay(){ return birthDay;}
    public void setBirthDay(LocalDate birthDay){this.birthDay = birthDay;}
    public LocalDate getDeath(){return death;}
    public void setDeath(LocalDate death){this.death = death;}
    public Human getSpouse(){return spouse;}
    public void setSpouse(Human spouse){this.spouse = spouse;}
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

}
