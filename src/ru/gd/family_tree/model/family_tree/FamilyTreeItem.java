package ru.gd.family_tree.model.family_tree;

import ru.gd.family_tree.model.gender.Gender;

import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T>{
    public int getAge();  //возвращает возраст либо годы жизни
    public int getId();
    public String getName();
    public T getMother();

    public T getFather();

    public T getSpouse();

    public Gender getGender();

    public List<T> getChildren();
    public void addChild(T child); //добавить ребёнка
    public void addMother(T mother);
    public void addFather(T father);

}
