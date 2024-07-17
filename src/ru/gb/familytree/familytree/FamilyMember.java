package ru.gb.familytree.familytree;

import java.io.Serializable;

public class FamilyMember implements Serializable {
    private String name;

    public FamilyMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}