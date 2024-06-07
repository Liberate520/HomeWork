package FamTree.ft;

import java.util.Comparator;
import FamTree.human.Human;

public class FamilyTreeComparatorByBirthDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {return o1.getBirthDate().compareTo(o2.getBirthDate());}
}
