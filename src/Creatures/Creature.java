package Creatures;

import java.io.Serializable;
import java.util.List;

public interface Creature<T> extends Serializable {
    int getAge();

    List<T> getChildren();

    List<T> getParents();

    List<T> getGrandparents();

    List<T> getGrandsons();

    boolean alive();

    String toString();

    void setParents(T mother, T father);

    void setChildren(T child);

    String getName();
}
