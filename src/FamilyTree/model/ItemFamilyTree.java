package FamilyTree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ItemFamilyTree<T> extends Serializable {
    long getId();

    String getName();

    LocalDate getBirthDate();

    LocalDate getDeathDate();

    Gender getGender();

    T getFather();

    T getMother();

    List<T> getChildren();

    void setChildren(List<T> children);

    T getSpouse();

    int getAge();

    String getInfo();

    void addChild(T child);

    void addGrandchild(T grandchild);

    List<T> getGrandchildren();

    void setId(long id);

    void setFather(T father);

    void setMother(T mother);

    void setSpouse(T spouse);
}