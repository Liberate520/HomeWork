package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    String getName();
    void setId(long id);
    long getId();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    boolean addParent(T human);
    boolean addChild(T human);
    List<T> getParents();
    List<T> getChildren();
    int getAge();

}
