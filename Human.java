package OOP.SemDZ.homeWork;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String name;
    private int id = 0;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate death;
    private Human father;
    private Human mather;
    private Human spouse = null;

    Human (String name, Gender gender, LocalDate birthDay, LocalDate death){
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.death = death;
        this.father = null;
        this.mather = null;
    }

    Human (String name, Gender gender, LocalDate birthDay, LocalDate death, Human father){
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.death = death;
        this.father = father;
        this.mather = null;
    }

    Human (String name, Gender gender, LocalDate birthDay, LocalDate death, Human father, Human mather){
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.death = death;
        this.father = father;
        this.mather = mather;
    }
    Human (String name, Gender gender, LocalDate birthDay, Human father, Human mather){
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.death = null;
        this.father = father;
        this.mather = mather;
    }
    
    Human (String name, Gender gender, LocalDate birthDay){
        this(name, gender, birthDay, null, null, null);
    }

    public Human getFather(){
        return this.father;
    }

    public String getMather(){
        return mather.getName();
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
