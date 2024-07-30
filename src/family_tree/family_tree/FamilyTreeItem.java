package family_tree.family_tree;

import java.util.List;

public interface FamilyTreeItem<T> {
    String getSurname();
    String getName();
    String getMiddleName();
    int getAge();
    long getId();
    void setId(long id);
    T getSpouse();
    void setSpouse(T spouse);
    boolean addParent(T parent);
    List<T> getParents();
    boolean addChild(T child);
    List<T> getChildren();
}
