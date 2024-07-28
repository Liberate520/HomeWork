package family_tree.family_tree;
import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> list;

    public FamilyTreeIterator( List<Human> list) {

        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return list.size() > index;
    }

    @Override
    public Human next() {
        return list.get(index++);
    }
}

