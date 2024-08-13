package homeWork.Tree;

import homeWork.Human.Human;
import java.util.Iterator;
import java.util.List;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {

    private int id;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return id > humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(id++);
    }
}
