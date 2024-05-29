package model.familyTree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getDayOfBirth();
    LocalDate getDayOfDeath();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T human);
}