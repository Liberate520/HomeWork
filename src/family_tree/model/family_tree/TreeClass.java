package family_tree.model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeClass<T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getDod();
    LocalDate getDob();
    List<T> getChildren();
    List<T> getParents();
    T getSpouse();
    void setSpouse(T human);

}
