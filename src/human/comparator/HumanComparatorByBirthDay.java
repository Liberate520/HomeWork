package human.comparator;

import family_tree.FamilyTreeElement;
import human.Human;

import java.util.Comparator;

public class HumanComparatorByBirthDay<E extends FamilyTreeElement> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        if(o1.getBirthDay().isAfter(o2.getBirthDay())) {
            return 1;
        }
        else{
            return -1;
        }
    }
}
