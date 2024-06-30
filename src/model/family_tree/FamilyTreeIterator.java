package model.family_tree;

import model.Creatures.Creature;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends Creature<T>>  implements Iterator<T> {
    private List<T> humanList;
    private int index;

    /**
     * Конструктор класса принимает List<Human>
     * устанавливает index = 0
     * @param humanList
     */
    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}
