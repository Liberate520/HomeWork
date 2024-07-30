package FamilyTree;
import Human.Human;
import  java.util.Comparator;

public class ComporatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human.Human o1, Human.Human o2) {
        return o1.get.BirthDate().compareTo(o2.getBirthDate());
    }
}
