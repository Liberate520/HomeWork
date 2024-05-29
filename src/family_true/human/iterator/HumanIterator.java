/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class HumanIterator
 * @version v1.0
 */

package family_true.human.iterator;

import family_true.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int index;
    private List<Human> humans;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > index;
    }

    @Override
    public Human next() {
        return humans.get(index++);
    }
}
