package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTreeSorter {
    public static <T extends FamilyMember> void sortByName(List<T> members) {
        Collections.sort(members, Comparator.comparing(FamilyMember::getName));
    }

    public static <T extends FamilyMember> void sortByBirthDate(List<T> members) {
        Collections.sort(members, Comparator.comparing(FamilyMember::getBirthDate));
    }
}