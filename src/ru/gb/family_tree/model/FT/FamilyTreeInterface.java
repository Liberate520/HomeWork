package ru.gb.family_tree.model.FT;

import java.util.List;

public interface FamilyTreeInterface<T> {
    void addHuman(T human);
    T findHumanByName(String name);
    T findHumanById(long id);
    void addChildById(long parentId, long childId);
    boolean removeHumanById(long id);
    void sortByName();
    void sortByBirthDate();
    List<T> getHumanList();

    long findMaxId();
}
