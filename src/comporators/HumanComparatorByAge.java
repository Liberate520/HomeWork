package comporators;

import human.Human;
import humanTree.ItemHumanTree;

import java.util.Comparator;

public class HumanComparatorByAge<T extends ItemHumanTree> implements Comparator <T> {
    public int compare(T human1, T human2) {
        int year1 = human1.getDob().getYear();
        int year2 = human2.getDob().getYear();
        return year1 - year2;
    }
}
