package Model.TypeOfRelationship;
import Model.Рerson.Рerson;
import java.util.Comparator;

public class ComparatorByName  implements Comparator<Рerson> {
    @Override
    public int compare(Рerson o1, Рerson o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}