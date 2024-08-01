package family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import family_tree.human.Human;

public interface TreeNode<T> extends Serializable {
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
