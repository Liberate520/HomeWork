package FamilyTree;
import Human.Human;
import  java.util.Comparator;
public class ComporatorByName implements Comparator<Human> {


    @Override
    public int compare(Human.Human o1, Human.Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
