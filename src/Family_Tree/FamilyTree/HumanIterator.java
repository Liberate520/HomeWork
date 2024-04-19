package Family_Tree.FamilyTree;

import Family_Tree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> HumanList;

    public HumanIterator(List<Human> humanList) {
        this.HumanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index<HumanList.size();
    }

    @Override
    public Human next() {
        return HumanList.get(index++);
    }
}



