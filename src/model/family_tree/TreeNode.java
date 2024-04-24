package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Интерфейс для описания члена фамильного дерева
 */
public interface TreeNode<T> extends Serializable {
    //  Method:
    //  Getters:
    int getId();

    LocalDate getBirthDate();

    int getAge();

    T getFather();

    T getMother();

    String getName();

    List<T> getParents();

    T getSpouse();

    //  Setters:
    void setId(int id);

    void setBirthDate(LocalDate birthDate);

    void setDeathDate(LocalDate deathDate);

    void setSpouse(T human);

    void addParent(T human);

    List<T> getChildren();

    void addChild(T human);
}