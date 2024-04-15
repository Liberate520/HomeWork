package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    int getId();

    void setId(int id);

    String getName();

    void setBirthDate(LocalDate birthDate);

    void setDeathDate(LocalDate deathDate);

    LocalDate getBirthDate();

    int getAge();

    T getFather();

    T getMother();

    List<T> getParents();

    void addParent(T human);

    List<T> getChildren();

    void addChild(T human);

    T getSpouse();

    void setSpouse(T human);
}