package com.oop.homeWorkOOP.human.comparators;

import java.util.Comparator;

import com.oop.homeWorkOOP.human.Human;

public class compareHumanByName implements Comparator<Human> {

    @Override
    public int compare(Human arg0, Human arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }

}
