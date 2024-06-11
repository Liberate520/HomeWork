package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.humans.Gender;
import ru.gb.family_tree.model.humans.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getDate_of_birth();
    LocalDate getDate_of_death();
    List<T> getParents();
    List<T> getChildren();
    Gender getGender();
    T getSpouse();
    void setSpouse(T human);

    int compareTo(Human o);
}
