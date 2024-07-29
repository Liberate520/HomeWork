package family_tree.human;

import java.util.Comparator;


public class HumanComparatorByBirthDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDayOfBirth().compareTo(o2.getDayOfBirth());
    }
}
