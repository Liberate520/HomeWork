package Family_Tree.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeVersatility<T> extends Serializable {
    void setID(long id);
    long getID();
    int getAge();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParents(T human);
    String getName();
    LocalDate getBirth();
    LocalDate getDeath();
    List<T> getParents();
    List<T> getChildren();
}
