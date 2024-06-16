package ru.gb.famaly_tree.human;

import java.util.List;

public interface DutiesOfTheCreature<T> extends Comparable<T>{
    boolean deadOrAlive();
    T getFather();
    T getMother();
    String getName();
    List<T> getChildren();
    Gender getGender();
    Integer Age();
    void addFather(T father);
    void addMother(T mother);
    void addChild(T child);
    void addChildren(List<T> children);
}
