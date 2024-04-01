package ru.gb.family_tree;

import ru.gb.family_tree.util.*;

import ru.gb.family_tree.util.ConsoleColors;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private String secondName;
    LocalDate dob, dod;
    private Gender gehder;
    private List<Human> children;
    private Human mother, father;

    public Human(String name, String secondName, LocalDate dob) {
        this.name = name;
        this.secondName = secondName;
        this.dob = dob;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(helpers.formatDataString("name", name) + "\n");
        sb.append(helpers.formatDataString("second Name", secondName) + "\n");
        sb.append(helpers.formatDataString("birth date", dob.toString()) + "\n");
        return sb.toString();
    }
}
