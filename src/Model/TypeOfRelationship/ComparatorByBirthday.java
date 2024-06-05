package Model.TypeOfRelationship;
import Model.Рerson.Рerson;

import java.util.Comparator;

public class ComparatorByBirthday implements Comparator<Рerson> {
    @Override
    public int compare(Рerson o1, Рerson o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}