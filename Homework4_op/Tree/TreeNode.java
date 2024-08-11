package Homework4_op.Tree;

import java.io.Serializable;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T human);


}
