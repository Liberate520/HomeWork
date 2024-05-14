package model.human;

import java.io.Serializable;

public interface Element<T> extends Serializable {
    void setId(int id);

    String getName();

    int getAge();

    int getID();

    void addParent(T search);

    void addChild(T search);
}
