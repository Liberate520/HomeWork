package ru.gb.family_tree.service;

import ru.gb.family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T> {
    public void setId(int id);
    public void setSpouse(T spouse);
    public int getId();
    String getName();
    LocalDate getBirthDay();
    int getAge();
    public Human getFather();
    public Human getSpouse();
    public List<T> getChildren();
    public boolean addChild(T child);
    public boolean addParent(T parent);
    public List<T> getParents();
}
