package ru.gb.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
public interface TreeMyTop <T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChildren(T human);
    boolean addParent(T human);
    String getName();
//    LocalDate getDeathDate;
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T human);

    void getSpouse(T human2);
}
