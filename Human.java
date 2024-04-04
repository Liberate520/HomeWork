package homeWork;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    String name;
    LocalDate dob, dod;
    Gender gender;
    List<Human> children = new ArrayList<>();
    Human mother, father;
    int age;
    
    public Human(String name, LocalDate dob, Gender gender){
        this.name=name;
        this.dob=dob;
        this.gender=gender;
        this.age=this.GetAge();
    }

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender){
        this.name=name;
        this.dob=dob;
        this.dod=dod;
        this.gender=gender;
        this.age=this.GetAge();
    }

    public int GetAge(){
        LocalDate endDate = dod != null ? dod : LocalDate.now();
        int age = endDate.getYear() - dob.getYear();

        if (dob.getMonthValue() > endDate.getMonthValue() || (dob.getMonthValue() == endDate.getMonthValue() && dob.getDayOfMonth() > endDate.getDayOfMonth())) {
            age--;
        }
        this.age=age;
        return age;
    }
    
    public void setFamily(Human parent) {
        if (parent == mother) {
            this.mother = parent;
        } else if (parent == father) {
            this.father = parent;
        } else {
            children.add(parent);
        }
    }
    
    public void addChild(Human child) {
        children.add(child);
    }
    
    public List<Human> getChildren() {
        System.out.println(this.name + "'s children(s): ");
        return children;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + this.age;
    }
}
