package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private Human mother, father;
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;


    public Human(String name, String birth, Gender gender){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.birthDate = LocalDate.parse(birth, dtf);
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public Human(String name, String birth, String death, Gender gender){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.name = name;
        this.birthDate = LocalDate.parse(birth, dtf);
        this.deathDate = LocalDate.parse(death, dtf);
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public void addChildren(Human child){
        children.add(child);
        if (gender == Gender.Male){
            child.father = this;
        } else{
            child.mother = this;
        }

    }

    public String getChildren(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children:\n");
        for (Human child: children){
            stringBuilder.append(child.name);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getParents(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parents:\n");
        stringBuilder.append(father.name);

        return stringBuilder.toString();
    }
}
