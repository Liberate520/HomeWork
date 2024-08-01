package family_tree;

import java.time.LocalDate;

public interface FamilyTreeItem<E> extends Comparable<E>{
    int getAge();
    String getName();
    LocalDate getBirthDate();
    Object getSpouse();
    void setSpouse(E human);
}
