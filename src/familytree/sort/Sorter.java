package familytree.sort;

import familytree.model.FamilyMember;
import familytree.model.Human;

import java.util.Collections;
import java.util.List;

public class Sorter {

    public static <T extends FamilyMember> void sortByName(List<T> members) {
        Collections.sort(members, new FamilyMemberNameComparator<>());
    }

    public static void sortByBirthDate(List<Human> humans) {
        Collections.sort(humans, new HumanBirthDateComparator());
    }
}