package lv.homeWork;

import java.util.Comparator;

public class CompareByBirth<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
