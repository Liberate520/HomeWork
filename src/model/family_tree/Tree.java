package model.family_tree;

import java.io.Serializable;

public interface Tree<T> extends Serializable {

    int add(T human);

    void sortByName();

    void sortByAge();

    void sortByID();

    void addParent(int child, int parent);

    void addChild(int child, int parent);

    boolean availability(int id);
}
