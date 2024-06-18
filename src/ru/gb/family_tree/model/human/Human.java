package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.FamilyItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyItem {
    private String name;
    private List<Human> parents;
    private Human spouse;
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;




    public Human(String name, String birth, String death, Gender gender){
        this(name, birth, gender);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.deathDate = LocalDate.parse(death, dtf);
    }

    public Human(String name, String birth, Gender gender){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.birthDate = LocalDate.parse(birth, dtf);
        this.deathDate = LocalDate.now();
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void addChildren(Human child){
        children.add(child);
        child.parents.add(this);
    }

    public List<Human> getChildren(){
       return this.children;
    }

    public String getName(){
        return this.name;
    }

    public List<Human> getParents(){
        return this.parents;
    }


    public String getSpouseString(){
        if(this.spouse != null){
        return this.spouse.getName();}
        else{
            return "Нет супруга";
        }
    }

    public Human getSpouse(){
        return spouse;
    }

    public void setSpouse(Human human){
        this.spouse = human;
    }

    public String getChildrenString(){
        if(!this.children.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for(Human child: children){
                stringBuilder.append(child.getName());
            }
            return stringBuilder.toString();}
        else{
            return "Нет детей";
        }
    }

    public String getParentsString(){
        if(!this.parents.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for(Human parent: parents){
                stringBuilder.append(parent.getName());
            }
            return stringBuilder.toString();}
        else{
            return "Нет родителей";
        }
    }

    public int getAge(){
        return Period.between(birthDate, deathDate).getYears();
    }

    @Override
            public String toString(){
            return "Имя: " + name + ", " +
                    "Возраст: " + getAge() + ", " +
                    "Супруг: " + getSpouseString() + ", " +
                    "Родители: " + getParentsString() + ", " +
                    "Дети: " + getChildrenString() + "\n";
        }
}
