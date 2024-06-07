package FamTree.ft;

import java.time.LocalDate;
import java.util.List;

public interface LifeFormGroup <T> extends Comparable <T> {
    String getName();
    int getAge();
    LocalDate getBirthDate();
    List<T> getChildren();
    List<T> getParents();
    List<T> getSiblings();
    boolean addChild(T child);
    boolean removeChild(T child);
    boolean addParent(T parent);
    boolean removeParent(T parent);
    int getNumChildren();
    int getNumSiblings();
    int getNumParents();
    long getId();

    Object getSpouse();

    void setSpouse(Object o);

    void setId(long l);
}
