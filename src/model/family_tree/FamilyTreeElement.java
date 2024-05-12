package model.family_tree;

import java.io.Serializable;

public interface FamilyTreeElement<T> extends Serializable {
    void setId(int id);

    String getName();

    int getAge();

    int getID();

    void addParent(int child, int parent);

    void addChild(int child, int parent);

    int add(T human);
    void sortByName();

    void sortByAge();

    void sortByID();

    boolean availability(int id);

    void addParent(T search);

    void addChild(T search);
}
