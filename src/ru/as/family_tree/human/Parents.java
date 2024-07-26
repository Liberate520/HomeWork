package ru.as.family_tree.human;

import java.time.LocalDate;

public class Parents extends Human {
    private String parent;


    public Parents(String name, LocalDate berthDate, Gender gender, String parent) {
        super(name, berthDate, gender);
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return super.toString() + ", parent: " + parent;
    }
}

