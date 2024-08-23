package model.family_tree;

import model.man.Gender;

import java.util.List;

public interface FamilyTreeItem<E> {
    String getName();

    int getAge();

    long getId();

    void setId(long id);

    List<E> getParents();

    boolean addChild(E child);

    List<E> getChildrens();

    Gender getGender();

    boolean addMother(E mother);

    boolean addFather(E father);

}
