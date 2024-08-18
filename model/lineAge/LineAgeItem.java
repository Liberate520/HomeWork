package com.oop.homeWorkOOP.model.lineAge;

import com.oop.homeWorkOOP.model.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface LineAgeItem<T extends LineAgeItem<T>> {

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    String getName();

    int getAge();

    T getFather();

    T getMother();

    List<T> getParents();

    List<T> getChildren();

    boolean addChild(T mem);

    Gender getGender();

    void setFather(T mem);

    void setMother(T mem);
}
