/**
 * @author Ostrovskiy Dmitriy
 * @created 28.05.2024
 * class HumanComparatorByLastName
 * @version v1.0
 */

package family_true.human.comparator;

import family_true.api.Entity;

import java.util.Comparator;

public class ComparatorByLastName<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if (o1.getLastName() == null) {
            return -1;
        }
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
