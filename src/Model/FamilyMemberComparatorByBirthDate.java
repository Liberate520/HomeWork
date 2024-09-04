package Model;

import java.util.Comparator;

public class FamilyMemberComparatorByBirthDate<T extends FamilyMember> implements Comparator<T> {
    @Override
    public int compare(T m1, T m2) {
        return m1.getBirthDate().compareTo(m2.getBirthDate());
    }
}