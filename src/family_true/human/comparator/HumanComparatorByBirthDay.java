/**
 * @author Ostrovskiy Dmitriy
 * @created 28.05.2024
 * class HumanComparatorByDate
 * @version v1.0
 */

package family_true.human.comparator;
import family_true.human.Human;

import java.util.Comparator;

public class HumanComparatorByBirthDay implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getBirthDay() == null) {
            return -1;
        }
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
