package familytree.sort;

import familytree.model.Human;

import java.util.Collections;
import java.util.List;

public class Sorter {

    public static void sortByName(List<Human> humans) {
        Collections.sort(humans, new HumanNameComparator());
    }

    public static void sortByBirthDate(List<Human> humans) {
        Collections.sort(humans, new HumanBirthDateComparator());
    }
}