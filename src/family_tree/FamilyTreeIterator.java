package family_tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> humanList;
    private int index;

    /**
     * Конструктор класса принимает List<Human>
     * устанавливает index = 0
     * @param humanList
     */
    public FamilyTreeIterator(List<Human> humanList) {
        this.humanList = humanList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
