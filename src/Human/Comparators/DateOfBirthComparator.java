package Human.Comparators;

import Human.Human;

import java.util.Comparator;

public class  DateOfBirthComparator<T extends NameWithDob> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
}