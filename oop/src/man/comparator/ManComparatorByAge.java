package man.comparator;

import man.Man;

import java.util.Comparator;

public class ManComparatorByAge implements Comparator <Man> {
    @Override
    public int compare(Man o1, Man o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
