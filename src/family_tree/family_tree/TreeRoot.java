package family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeRoot<T> extends Serializable {
    void setId(int id);
    int getId();
    boolean addChild (T human);
    boolean addParent (T human);
    String getName();
    String getSurName();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    List<T> getParents();
    List<T> getChildren();
}
