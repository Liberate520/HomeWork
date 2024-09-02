package Model;

import java.util.Comparator;

public class FamilyMemberComparatorByName<T extends FamilyMember> implements Comparator<T> {
    @Override
    public int compare(T m1, T m2) {
        return m1.getName().compareTo(m2.getName());
    }
}