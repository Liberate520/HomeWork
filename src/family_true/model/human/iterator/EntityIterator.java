/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class HumanIterator
 * @version v1.0
 */

package family_true.model.human.iterator;

import java.util.Iterator;
import java.util.List;

public class EntityIterator<T> implements Iterator<T> {

    private int index;
    private List<T> entities;

    public EntityIterator(List<T> entities) {
        this.entities = entities;
    }

    @Override
    public boolean hasNext() {
        return entities.size() > index;
    }

    @Override
    public T next() {
        return entities.get(index++);
    }
}
