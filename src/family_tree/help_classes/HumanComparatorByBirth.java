package family_tree.help_classes;

import family_tree.program_classes.Human;

import java.util.Comparator;

public class HumanComparatorByBirth implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());

    }
}
