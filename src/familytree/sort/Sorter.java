package familytree.sort;

import familytree.model.Human;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    public static void sortByName(List<Human> humans) {
        Collections.sort(humans, Comparator.comparing(Human::getName));
    }

    public static void sortByBirthDate(List<Human> humans) {
        Collections.sort(humans, Comparator.comparing(Human::getBirthDate));
    }
}