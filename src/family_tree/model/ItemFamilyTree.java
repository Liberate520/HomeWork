package family_tree.model;

import java.io.Serializable;
import java.util.List;

public interface ItemFamilyTree<E> extends Serializable {

    void setId(long l);
    List<E> getParents();
    boolean addChild(E human);
    List <E> getChildren();
    boolean addParent(E human);
    String getName();
    E getSpouse();
    void setSpouse(E human2);
    long getId();

    int getAge();

}
