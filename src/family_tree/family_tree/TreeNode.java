package family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<E> extends Serializable {
    void setId(long id);
    long getId();
    E getFather();
    E getMother();
    boolean addChild(E node);
    boolean addParent(E node);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<E> getParents();
    List<E> getChildren();
    E getSpouse();
    void setSpouse(E node);
    Object getDateOfBirth();
}
