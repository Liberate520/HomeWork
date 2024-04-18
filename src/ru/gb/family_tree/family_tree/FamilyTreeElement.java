package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


public interface FamilyTreeElement<T> extends Serializable {
    long getId();
    void setId(long id);
    void PrintId();
    String getName();
    void setName(String name);
    void PrintName();
    LocalDate getDob();
    void setDob(LocalDate dob);
    void PrintDob();
    LocalDate getDod();
    void setDod(LocalDate dod);
    void PrintDod();
    Gender getGender();
    void setGender(Gender gender);
    void PrintGender();
    List<T> getChildren();
    boolean addChild (T child);
    String getChildrenAbout();
    void PrintChildren();
    T getMother();
    void setMother(T mother);
    String getMotherAbout();
    void PrintMother();
    T getFather();
    void setFather(T father);
    String getFatherAbout();
    void PrintFather();
    HashMap<T, SpouseStatus> getSpouse();
    boolean addSpouse(T spouse, SpouseStatus status);
    String getSpousesAbout();
    void PrintSpouses();
    int getAge();
    String getLifeStatus();
    void PrintAge();
    String getAbout();

}


//----------------------------------------------------------
