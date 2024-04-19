package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.SpouseStatus;

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
    void addParent(T parent);
    HashMap<T, SpouseStatus> getSpouse();
    void addSpouse(T spouse, SpouseStatus status);
    String getSpousesAbout();
    void PrintSpouses();
    int getAge();
    String getLifeStatus();
    void PrintAge();
    String getAbout();

}


//----------------------------------------------------------
