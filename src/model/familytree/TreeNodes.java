package model.familytree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNodes<T> extends Serializable {
    void setId(int id);

    int getId();

    String getName();

    LocalDate getBirthDay();

    LocalDate getDeathDay();

    T getMother();

    T getFather();

    T getSpouse();

    List<T> getChildren();

    List<T> getParents();

    void setSpouse(T person);

    void addChild(T person);

    void addParent(T person);
}