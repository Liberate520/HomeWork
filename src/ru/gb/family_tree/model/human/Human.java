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


    public Human getSpouse(){
        return this.spouse;
    }

    public int getAge(){
        return Period.between(birthDate, deathDate).getYears();
    }

    @Override
            public String toString(){
            return "Name: " + name + "\n" +
                    "Age: " + getAge() + "\n" +
                    "Spouse: " + getSpouse() + "\n" +
                    getParents() +
                    getChildren() + "\n";
        }
}
