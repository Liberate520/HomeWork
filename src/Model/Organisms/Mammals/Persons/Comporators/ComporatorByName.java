package Model.Organisms.Mammals.Persons.Comporators;
import Model.Organisms.Organism;

import java.util.Comparator;

public class ComporatorByName<T extends Organism> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
