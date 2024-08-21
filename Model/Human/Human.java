package homeWork.Model.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import homeWork.Model.Tree.TreeItem;


public class Human  implements Serializable, TreeItem<Human> {
    private int id;
    private static int currentId = 0;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Human father;
    private List<Human> children;
    private Human mother;


    public Human(String name,  Gender gender, LocalDate birthday, LocalDate deathDay, Human mother, Human father, List<Human> children){
        this.id = ++currentId;
        this.birthDay = birthday;
        this.gender = gender;
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();;
        this.deathDay = deathDay;
    }

    public Human(int id, String name, Gender gender, LocalDate birthDay, LocalDate deathDay) {
        this(name, gender, birthDay, deathDay, null, null, null);
    }





    public int getId() {
        return id;
    }


    public String getName() {return name;}

    public Gender getGender() {return gender;}

    public LocalDate getBirthday() {return birthDay;}

    public Human getMother() {return  mother;}

    public Human getFather() {return father;}

    public List<Human> getChildren() {return  children;}

    private LocalDate getDeathDay(){return deathDay;}

    public void setChildren(List<Human> children) {
        this.children = children;
    }




    public int getAge(){
        if(deathDay == null){
            return getPeriod(birthDay, LocalDate.now());
        }
        else{
            return getPeriod(birthDay,deathDay);
        }
    }

    private int getPeriod(LocalDate birthday, LocalDate deathDay){
        Period diff = Period.between(birthday, deathDay);
        return diff.getYears();
    }

    public String showMather(){
        if (mother == null){
            return "отсутствует";
        }
        return getMother().getName();
    }

    public String showFather(){
        if (father == null){
            return "отсутствует";
        }
        return getFather().getName();
    }



    public void addChild(Human child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        // Проверяем, что ребенок еще не был добавлен
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
        // Также добавляем ребенка в список детей матери и отца, если они указаны
        if (child.mother != null && !child.mother.children.contains(child)) {
            child.mother.children.add(child);
        }
        if (child.father != null && !child.father.children.contains(child)) {
            child.father.children.add(child);
        }
    }

    private String getChildrenNames() {
        if (children.isEmpty()) {
            return "не имеет детей";
        }
        StringBuilder childrenNames = new StringBuilder();
        for (Human child : children) {
            childrenNames.append(child.name).append(", ");
        }
        return childrenNames.substring(0, childrenNames.length() - 2);
    }


    @Override
    public String toString() {
        if ( deathDay == null ){
            return "id: " + id + ", name: " + name + ", gender: " + gender + ", age " + getAge() + ", mother: " + showMather() +
                    ", father " + showFather() + "; children: " + getChildrenNames();
        }
        else {
            return " id: " + id + ", name: " + name + ", gender: " + gender + ", birthday " + birthDay + ", deathDay " + deathDay + ", mother: " + showMather() + ", father " + showFather() + "; children: " + getChildrenNames();
        }
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

}