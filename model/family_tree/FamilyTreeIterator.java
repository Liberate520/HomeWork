package model.family_tree;

import java.util.Iterator;
import java.util.List;

// Применяем SRP: Класс FamilyTreeIterator отвечает за итерацию по людям в дереве.
public class FamilyTreeIterator<E extends FamilyTreeItem<E>> implements Iterator<E> {
    private int curIndex;
    private List<E> humans;

    public FamilyTreeIterator(List<E> humans) {
        this.humans = humans;
        this.curIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return curIndex < humans.size();
    }

    @Override
    public E next() {
        return humans.get(curIndex++);
    }
}
