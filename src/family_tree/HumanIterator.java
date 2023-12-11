package family_tree;
import human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int index = 0;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList){
        this.humanList = humanList;
    }

    public boolean hasNext() {
        return index<humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
