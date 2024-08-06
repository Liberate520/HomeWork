package family_tree.model.family_tree;

import java.util.Iterator;
import java.util.List;

class familyTreeIterator<T extends ItemFamilyTree<T>> implements Iterator<T> {
    private int currentId;
    private List<T> list;

    public familyTreeIterator(List<T> list) {

        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() > currentId;
    }

    @Override
    public T next() {
        return list.get(currentId++);
    }
}

