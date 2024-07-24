package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    String getName();
    int getId();
    LocalDate getDateOfBirthday();
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
}
