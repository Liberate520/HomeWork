package human.comparators;

import java.util.Comparator;

import human.Human;

public class ComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        // return Integer.compare(o1.getAge(), o2.getAge());
        return o1.getAge() - o2.getAge();
    }


}
