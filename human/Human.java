package homeWork.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import homeWork.familyTree.FamTree;
import homeWork.gender.Gender;

public class Human implements Serializable, Comparable<Human>, FamTree{
    String name;
    LocalDate dob, dod;
    Gender gender;
    List<Human> children = new ArrayList<>();
    Human mother, father;
    
    public Human(String name, LocalDate dob, Gender gender){
        this(name, dob, null, gender, null, null);
    }

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender){
        this(name, dob, dod, gender, null, null);
    }

    public Human(String name, LocalDate dob, Gender gender, Human mother, Human father){
        this(name, dob, null, gender, mother, father);
    }

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father){
        this.name=name;
        this.dob=dob;
        this.dod=dod;
        this.gender=gender;
        this.mother = mother;
        this.father = father;

        if (mother != null)
            mother.children.add(this);
        if (father != null)
            father.children.add(this);
    }

    public int getAge(){
        LocalDate endDate = dod != null ? dod : LocalDate.now();
        int age = endDate.getYear() - dob.getYear();

        if (dob.getMonthValue() > endDate.getMonthValue() || (dob.getMonthValue() == endDate.getMonthValue() && dob.getDayOfMonth() > endDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }
    
    public LocalDate getDob() {
        return dob;
    }
    
    public String getName() {
        return name;
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
        return "Name: " + name + ", age: " + Integer.toString(getAge()) +", date of Birthday: " + dob+ ", gender: " +  gender + ", mother: " + (mother != null ? mother.name : "Unknown") + ", father: " + (father != null ? father.name : "Unknown");
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
