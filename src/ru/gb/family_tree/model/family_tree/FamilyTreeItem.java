package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.info_collector.InfoCollector;
import ru.gb.family_tree.model.human.enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    String getName();
    int getId();
    LocalDate getDateOfBirthday();
    LocalDate getDateOfDeath();
    int getAge();
    List<T> getChildren();
    Gender getGender();
    void setMother(T human);
    void setFather(T human);
    void setChildrenList(List<T> children);
    T getMother();
    T getFather();
    String getSurname();
    String getPatronymic();
    void editObject(InfoCollector infoCollector, CollectorItems editedItem);
}
