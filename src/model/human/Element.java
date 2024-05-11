package model.human;

import java.io.Serializable;

public interface Element<T> extends Serializable {
    int getID();

    String getName();

    int getAge();

    void addParent(Element element);

    void addChild(Element element);

    void setId(int id);

    Gender getGender();
}
