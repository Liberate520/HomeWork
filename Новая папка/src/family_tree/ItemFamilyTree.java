package family_tree;

import java.io.Serializable;
import java.util.List;

public interface ItemFamilyTree<T> extends Serializable {
    int getAge();
    String getByName();
    long getId();
    long setId(long l);
    void getSpouse();
    void setSpouse();
    List<T> getParents();
    List<T> getChildren();
    boolean addChild(T human);
    boolean addParent(T human);
    T getMother();
    T getFather();
}
