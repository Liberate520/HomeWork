package family_tree;

import java.time.LocalDate;
import human.Gender;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T> {
    String getFirstName();

    String getLastName();

    LocalDate getBirthDate();

    public Gender getGender();

    int getAge();

    long getId();

    void setId(long ID);

    List<T> getParents();

    List<T> getChildren();

    void setChildren(List<T> children);

    boolean addChild(T child);

    boolean addParent(T parent);

    T getSpouse();

    void setSpouse(T spouse);

    String getInfo();
}
