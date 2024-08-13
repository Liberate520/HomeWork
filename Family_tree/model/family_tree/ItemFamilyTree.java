package Family_tree.model.family_tree;

import java.io.Serializable;
import java.util.List;

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
    void addFather(T human);
    void addMother(T human);
    long getId();
}
