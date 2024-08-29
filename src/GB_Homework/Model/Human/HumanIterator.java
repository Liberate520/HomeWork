package GB_Homework.Model.Human;

import GB_Homework.Model.Family_Tree.FamilyTreeItem;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeItem<T>> implements Iterator<T> {
    List<T> humanList;
    int index;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size()>index;
    }

    @Override
    public T next() {
        return humanList.get(index++);

    }
}
