package Human.comparators;

import Human.Human;

import java.util.Comparator;

public class HumanComparatorByChildrenNum implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getChildren().size() - o2.getChildren().size();
    }
}
