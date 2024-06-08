package OOP.SemDZ.homeWork.model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, Creature {
    private String name;
    private int id = 0;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate death = null;
    private Human father = null;
    private Human mather = null;
    private Human spouse = null;
    private List<Human> child;

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
    public <Human>void setSpouse(Human spouse){this.spouse = (OOP.SemDZ.homeWork.model.human.Human) spouse;}
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public List<Human> getChildren(){ return child;}
    public void setChildren(List<Human> children){this.child = children;}
    public void addChildren( Human human){
        child.addLast(human);
     }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder hl = new StringBuilder();
        hl.append("name ");
        hl.append(name);
        hl.append(", id ");
        hl.append(id);
        hl.append(", gender ");
        hl.append(getGender());
        hl.append(", birthaday ");
        hl.append(getBirthDay());
        hl.append(", death ");
        hl.append(getDeath());
        hl.append(", father ");
        hl.append(getFather());
        hl.append(", mather ");
        hl.append(getMather());
        hl.append(", spouse ");
        hl.append(getSpouse());
        hl.append(", children ");
        hl.append(getChildren());

        return hl.toString();
    }

    @Override
    public int compareTo(Human o) {
                
        return name.compareTo(o.name);
    }

    

}
