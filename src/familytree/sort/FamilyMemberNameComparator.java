package familytree.sort;

import familytree.model.FamilyMember;

import java.util.Comparator;

public class FamilyMemberNameComparator<T extends FamilyMember> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}