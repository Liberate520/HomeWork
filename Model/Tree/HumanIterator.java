package homeWork.Model.Tree;

import java.util.Iterator;
import java.util.List;

import homeWork.Model.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<Human> implements Iterator<Human> {

    private int id;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return id > humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(id++);
    }
}
