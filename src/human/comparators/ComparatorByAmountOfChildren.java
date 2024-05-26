package human.comparators;

import java.util.Comparator;

import human.Human;

public class ComparatorByAmountOfChildren implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }


}
