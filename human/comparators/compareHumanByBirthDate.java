package com.oop.homeWorkOOP.human.comparators;

import java.util.Comparator;

import com.oop.homeWorkOOP.human.Human;
import com.oop.homeWorkOOP.lineAge.LineAgeItem;

public class compareHumanByBirthDate<T extends LineAgeItem> implements Comparator<T> {

    @Override
    public int compare(T arg0, T arg1) {
        return arg0.getBirthDate().compareTo(arg1.getBirthDate());
    }

}
