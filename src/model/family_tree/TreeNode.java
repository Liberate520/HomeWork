//package model.family_tree;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//import java.util.List;
//
//public interface TreeNode<T> extends Serializable {
//    void setId(long id);
//    long getId();
//    T getFather();
//    T getMother();
//    boolean addChild(T human);
//    boolean addParent(T human);
//    String getName();
//    LocalDate getDeathDate();
//    LocalDate getBirthDate();
//    List<T> getParents();
//    List<T> getChildren();
//    T getSpouse();
//    void setSpouse(T human);
//}

package model.family_tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<E> {
    long getId();
    void setId(long id);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getParents();
    List<E> getChildren();
    void setSpouse(E spouse);
    E getSpouse();
    boolean addChild(E child);
    boolean addParent(E parent);
}

