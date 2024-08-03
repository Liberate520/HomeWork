package Family_tree.family_tree;

import java.util.List;

import Family_tree.human.Human;

public interface ItemFamilyTree<T> extends Serializable {
    String getName();
    int getAge();
    void setId(long l);
    T getSpouse();
    T getFather();
    T getMother();
    void setSpouse(T human);
    List<T> getChildren();
    void addChild(T human);
    void addToFather(T human);
    void addToMother(T human);
    void addFather(T human);
    void addMother(T human);
}
