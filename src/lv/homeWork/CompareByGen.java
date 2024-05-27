package lv.homeWork;

import java.util.Comparator;

public class CompareByGen<E extends Human> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o2.getGeneration(), o1.getGeneration());
    }
}
