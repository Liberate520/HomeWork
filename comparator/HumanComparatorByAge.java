package OOP.SemDZ.homeWork.comparator;

import java.util.Comparator;

import OOP.SemDZ.homeWork.human.Human;

public class HumanComparatorByAge<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }    
}
