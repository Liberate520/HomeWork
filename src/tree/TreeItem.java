package tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeItem<T> extends Serializable {

    T getMother();
    T getFather();

    void addChild(T person);
    void addParent(T person);
    String getFullName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<T> getChildrenList();
    List<T> getParents();


}
