package Human;

import java.util.Comparator;

public class HumanComparatorbyAmountOfChildren implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getHumansChildrenList().size()-o2.getHumansChildrenList().size();
    }
}
