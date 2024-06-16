/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class FamilyTreeIterator
 * @version v1.0
 */

package family_true.model.family_tree.iterator;

import family_true.model.family_tree.Entity;
import family_true.model.family_tree.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends Entity<T>> implements Iterator<FamilyTree<T>> {

    private int index;
    private List<FamilyTree<T>> familyTreeList;

    public FamilyTreeIterator(List<FamilyTree<T>> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    @Override
    public boolean hasNext() {
        return familyTreeList.size() > index;
    }

    @Override
    public FamilyTree<T> next() {
        return familyTreeList.get(index++);
    }
}
