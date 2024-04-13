package family_tree.human;

import java.util.Comparator;

public class HumanComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getDateOfBirth().compareTo(h2.getDateOfBirth());
    }
}
