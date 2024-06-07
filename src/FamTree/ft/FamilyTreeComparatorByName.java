package FamTree.ft;
import java.util.Comparator;
import FamTree.human.Human;
public class FamilyTreeComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) { return o1.getName().compareTo(o2.getName()); }
}
