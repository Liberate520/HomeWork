package seminar2;

import java.util.Comparator;

public class HumanComparatorByChildren implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}
