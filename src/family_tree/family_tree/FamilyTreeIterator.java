package family_tree.family_tree;

import family_tree.human.Human;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends TreeNode<E>> implements Serializable, Iterator<E> {
    private List<Human> list;
    private int position;

    public FamilyTreeIterator(List<Human> list) {
        this.list = list;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public E next() {
        return list.get(position++);
    }
}
