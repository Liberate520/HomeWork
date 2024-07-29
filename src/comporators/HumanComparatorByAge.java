package comporators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator <Human> {
    public int compare(Human human1, Human human2) {
        int year1 = human1.getDob().getYear();
        int year2 = human2.getDob().getYear();
        return year1 - year2;
    }
}
