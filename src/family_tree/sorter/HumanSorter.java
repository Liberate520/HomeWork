package family_tree.sorter;

import family_tree.human.Human;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HumanSorter {

    public static void sortByName(List<Human> humans) {
        Collections.sort(humans, Comparator.comparing(Human::getName));
    }

    public static void sortByBirthDate(List<Human> humans) {
        Collections.sort(humans, Comparator.comparing(Human::getBirthDate));
    }
}