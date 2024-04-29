package src.model;

import java.util.Comparator;

public class PersonComporatorByName<T extends FamilyObject<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
        
    }

}
