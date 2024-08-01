package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.List;

public interface TreeInterface<E> extends Serializable {
    String getName();
    int getAge();
    boolean addChild(E human);
    boolean addParent(E human);
    long getId();
    void setId(long id);
    E getSpouse();
    void setSpouse(E human);
    int compareTo(E o);
    List <E> getChildren();
    List <E> getParents();


}
