package Human.Comparators;

import Human.Human;

import java.util.Comparator;

public class  NameComparator<T extends NameWithDob> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
