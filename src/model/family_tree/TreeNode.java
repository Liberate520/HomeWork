package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getChildren();
    void addChild(T human);
    T getMother();
    T getFather();
    T getSpouse();
}
