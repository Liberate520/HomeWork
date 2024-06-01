package Family_tree.Humans;

import java.util.Comparator;

public class ComparatorByName<T extends EndothermalInterface<T>> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
