package family;

import human.Gender;
import java.util.List;

public interface GroupItem<T> extends Comparable<T> {
    long getId();
    void setId(long id);

    String getName();
    Gender getGender();
    int getAge();

    List<T> getParents();
    void addParent(T parent);

    List<T> getChildren();
    void setChildren(T child);

    T getSpouse();
    void setSpouse(T spouse);
}
