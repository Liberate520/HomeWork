package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;


    public Human(int id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

//    public Human(String name, Gender gender, LocalDate birthDate) {
//        this(name, gender, birthDate, null,null,null);
//    }
//
//    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
//        this(name, gender, birthDate, null,father,mother);
//    }


    public Human getSpouse() { return spouse; }

    public void setSpouse(Human spouse) { this.spouse = spouse; }

    public long getId() { return id; }

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

    public Human getFather() { return father; }

    public void setFather(Human father) { this.father = father; }

    public Human getMother() { return mother; }

    public void setMother(Human mother) { this.mother = mother; }

    public List<Human> getChildren() { return children;  }

    public void setChildren(List<Human> children) { this.children = children; }





    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }


    public String getFatherInfo() {
        String res = "father: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "mother: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (!children.isEmpty()) {
            res.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("None");
        }
        return res.toString();
    }

    public String getSpousInfo(){
        String res = "spous: ";
        if (spouse == null){
            res += "none";
        }
        else {
            res += spouse.getName();
        }
        return res;
    }

    private int getDifference(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public int getAge(){
        if (deathDate == null){
            return getDifference(birthDate, LocalDate.now());
        }
        else {
            return getDifference(birthDate, deathDate);
        }
    }



    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" Name: ");
        sb.append(getName());
        sb.append(", Gender: ");
        sb.append(getGender());
        sb.append(", Age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpousInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if( this == obj ){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
