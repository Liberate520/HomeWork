package familyTreeApi.familyTree.comparators;

import familyTreeApi.member.Member;

import java.util.Comparator;

public class MemberComparatorByFirstName<E extends Member> implements Comparator<E> {
    @Override
    public int compare(E p1, E p2) {
        int result = p1.getName().get(0).compareTo(p2.getName().get(0));
        if (result == 0) result = p1.getName().get(1).compareTo(p2.getName().get(1));
        if (result == 0) {
            result = p1.getBornDate().compareTo(p2.getBornDate());
        }
        return result;
    }
}