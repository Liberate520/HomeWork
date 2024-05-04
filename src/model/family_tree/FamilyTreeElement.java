package model.family_tree;

import java.io.Serializable;

public interface FamilyTreeElement<T> extends Serializable {
    void setId(int id);

    String getName();

    int getAge();

    int getID();
}
