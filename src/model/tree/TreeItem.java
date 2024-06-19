package model.tree;

import model.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> extends Comparable<T> {
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    long  getId();
    void setID(long id);
    String  getLastName();
    void setLastName(String lastName);
    String getName();
    void setName(String name);
    boolean setDateOfBirth(LocalDate dateOfBirth);
    int getAge();
    Gender getGender();
    void setGender(Gender gender);
    List<T> getChildren();
    int getChildrenListSize();
    boolean addChildToList(T child);
    boolean removeChildFromList(T child);
    T getFather();
    void setFather(T father);
    T getMother();
    void setMother(T mother);
    String getInfo();
    String getChildInfo();
    String getHTML();





}
