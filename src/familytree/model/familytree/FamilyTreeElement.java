package familytree.model.familytree;

import familytree.model.human.gender.Gender;

import java.io.Serializable;
import java.util.List;

public interface FamilyTreeElement<T> extends Serializable {
    String getName();
    int getAge();
    String getChildren();
    String getInfo();
    void addChild(List<T> children, T child);
    Gender getGender();
    void setChildren(List<T> children);
}
