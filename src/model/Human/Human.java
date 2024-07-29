package model.Human;

import model.familyTree.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, ItemFamilyTree {
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human(String name, LocalDate dob, Gender gender){
        this.children = new ArrayList<>();

        this.setName(name);
        this.setDob(dob);
        this.setGender(gender);
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
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

    public void setFather(ItemFamilyTree father) {
        this.father = (Human) father;
    }

    public Human getMother() {
        return mother;
    }


    public void setMother(ItemFamilyTree mother) {
        this.mother = (Human) mother;
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human child : children){
            if(stringBuilder.isEmpty()){
                stringBuilder.append(child.getName());
            }
            else{
                stringBuilder.append(", ");
                stringBuilder.append(child.getName());
            }
        }
        return stringBuilder.toString();
    }

    public void addChild(ItemFamilyTree child) {
        children.add((Human) child);
    }

    public int getAge(){
        LocalDate now = LocalDate.now();
        return Period.between(dob, now).getYears();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", пол: ");
        if (gender == Gender.male){
            stringBuilder.append("мужчина");
        }
        else {
            stringBuilder.append("женщина");
        }
        stringBuilder.append(", Дата рождения: ");
        stringBuilder.append(dob);
        if (dod != null){
            stringBuilder.append(", Дата смерти: ");
            stringBuilder.append(dod);
        }
        if (father != null){
            stringBuilder.append(", Папа: ");
            stringBuilder.append(father.getName());
        }
        if (mother != null){
            stringBuilder.append(", Мама: ");
            stringBuilder.append(mother.getName());
        }

        if (!children.isEmpty()){
            stringBuilder.append(", Дети: ");
            stringBuilder.append(this.getChildren());
        }

        return stringBuilder.toString();
    }


    @Override
    public int compareTo(Human anotherHuman) {
        return this.name.compareTo(anotherHuman.name);
    }
}