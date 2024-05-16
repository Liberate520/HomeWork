package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.HashMap;


public interface FamilyTreeElement<T> extends Serializable {
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);
    LocalDate getDob();
    void setDob(LocalDate dob);
    LocalDate getDod();
    void setDod(LocalDate dod);
    Gender getGender();
    void setGender(Gender gender);
    List<T> getChildren();
    boolean addChild (T child);
    String getChildrenAbout();
    T getMother();
    void setMother(T mother);
    String getMotherAbout();
    T getFather();
    void setFather(T father);
    String getFatherAbout();
    void addParent(T parent);
    HashMap<T, SpouseStatus> getSpouse();
    void addSpouse(T spouse, SpouseStatus status);
    String getSpousesAbout();
    int getAge();
    String getLifeStatus();
    String getAbout();

}


//----------------------------------------------------------
