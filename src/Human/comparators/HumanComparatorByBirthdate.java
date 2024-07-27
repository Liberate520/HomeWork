package Human.comparators;

import FamilyTree.FamilyTreeItem;
import Human.Human;

import java.util.Comparator;
import java.time.LocalDate;
import java.time.Period;

public class HumanComparatorByBirthdate<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Period.between(o1.getBirthDate(), LocalDate.now()).getYears() -
                Period.between(o2.getBirthDate(), LocalDate.now()).getYears();
    }
}
