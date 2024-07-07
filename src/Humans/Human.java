package Humans;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import FamilyTree.ItemFamilyTree;

public class Human implements Serializable, ItemFamilyTree{
    // private int ID;
    private String name;
    private LocalDate dateOfBorn, dateOfDeath;
    private Gender gender;
    private Human father, mother;
    private List<Human> children; 

    public Human(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender, Human father, Human mother) {
        // ID = -1;
        this.name = name;
        this.dateOfBorn = dateOfBorn;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        
    }

    public Human(String name, LocalDate dateOfBorn, LocalDate dateOfDeath, Gender gender) {
        this(name, dateOfBorn, dateOfDeath, gender, null, null);
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBorn() {
        return dateOfBorn;
    }
    public void setDateOfBorn(LocalDate dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
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
    public List<Human> getChildren() {
        return children;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    // public int getID() {
    //     return ID;
    // }
    // public void setID(int iD) {
    //     this.ID = iD;
    // }

    // @Override
    // public String toString() {
    //     return "Human [name=" + name + ", dateOfBorn=" + dateOfBorn + ", dateOfDeath=" + dateOfDeath + ", gender="
    //             + gender + ", father=" + father + ", mother=" + mother + ", grandFather=" + grandFather
    //             + ", grandMother=" + grandMother + ", children=" + children + ", grandchildren=" + grandchildren + "]";
    // }
    
    // @Override
    // public String toString() {
    //     return "Name: " + name + System.lineSeparator()
    //     + "Date of born: " + dateOfBorn + System.lineSeparator()
    //     + "Date of death: " + dateOfDeath + System.lineSeparator()
    //     + "Gender: " + gender + System.lineSeparator();
    // }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(gender + ";");
        sb.append(" " + getDateOfBorn() + " ");
        sb.append(" " + getDateOfDeath() + " ");
        sb.append(getGender() + ";");
        sb.append(getFatherInfo());
        sb.append(getMotherInfo());
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getFatherInfo(){
        String res = " папа: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += " нет данных; ";
        }
        return res;
    }

    public String getMotherInfo(){
        String res = " мама: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += " нет данных; ";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append(" дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 0; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append(" детей нет; ");
        }
        return res.toString();
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) {
    //         return true;
    //     }
    //     if (!(obj instanceof Human)) {
    //         return false;
    //     }
    //     Human human = (Human) obj;
    //     return human.getID() == getID();
    // }

}
