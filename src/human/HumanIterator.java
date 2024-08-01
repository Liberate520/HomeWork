package human;

import family_tree.FamilyTree;
import family_tree.FamilyTreeItem;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E extends FamilyTreeItem<E>> implements Iterator<E> {
    private int curIndex;
    private List<E> humans;

    public HumanIterator(FamilyTree familyTree) {
        this.humans = familyTree.getHumans();
        this.curIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return curIndex < humans.size() -1;
    }

    @Override
    public E next() {
        if (!hasNext()){
            return null;
        }
        return humans.get(curIndex++);
    }
}