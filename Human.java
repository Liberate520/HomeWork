package homeWork;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    String name;
    LocalDate dob, dod;
    Gender gender;
    List<Human> children = new ArrayList<>();
    Human mother, father;
    
    public Human(String name, LocalDate dob, Gender gender){
        this(name, dob, null, gender);
    }

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender){
        this.name=name;
        this.dob=dob;
        this.dod=dod;
        this.gender=gender;
    }

    public int getAge(){
        LocalDate endDate = dod != null ? dod : LocalDate.now();
        int age = endDate.getYear() - dob.getYear();

        if (dob.getMonthValue() > endDate.getMonthValue() || (dob.getMonthValue() == endDate.getMonthValue() && dob.getDayOfMonth() > endDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }
    
    public void addChild(Human child, Human mother, Human father) {
        child.mother = mother;
        child.father = father;

        mother.children.add(child);
        father.children.add(child);
        
        this.children.add(child);
    }
    
    public List<Human> getChildren(Human parent) {
        List<Human> childrenOfParent = new ArrayList<>();
        for (Human child : this.children) {
            if ((child.mother == parent || child.father == parent) && !childrenOfParent.contains(child)) {
                childrenOfParent.add(child);
            }
        }
        return childrenOfParent;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + Integer.toString(getAge()) + ", gender: " +  gender + ", mother: " + (mother != null ? mother.name : "Unknown") + ", father: " + (father != null ? father.name : "Unknown");
    }
}
