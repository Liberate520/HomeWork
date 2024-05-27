package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private Human mother, father;
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;


    public Human(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public Human(String name, LocalDate birthaDate, Gender gender){
        this.name = name;
        this.birthDate = birthaDate;
        this.deathDate = LocalDate.now();
        this.gender = gender;
    }

    public void addChildren(Human child){
        this.children = new ArrayList<>();
        children.add(child);

    }

    public String getChildren(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children:\n");
        for (Human child: children){
            stringBuilder.append(child.name);
        }
        return stringBuilder.toString();
    }

    public String getName(){
        return name;
    }
}
