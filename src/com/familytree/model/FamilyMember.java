package com.familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyMember<T> extends Serializable {
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();

    Gender getGender();

    T getFather();
    T getMother();
    void setMother(T mother);
    void setFather(T father);
    void addChild(T child);
    List<T> getChildren();
}