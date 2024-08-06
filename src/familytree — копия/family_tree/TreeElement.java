package familytree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public interface TreeElement<T> extends Serializable {
    String getName();
    List<T> getChildren();
    List<T> getParents();
    void addChild(T child);
    void addParent(T parent);
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    int calculateAge();
}