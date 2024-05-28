/**
 * @author Ostrovskiy Dmitriy
 * @created 26.05.2024
 * class FamilyTreeIterator
 * @version v1.0
 */

package family_true.family_tree.iterator;

import family_true.family_tree.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<FamilyTree> {

    private int index;
    private List<FamilyTree> familyTreeList;

    public FamilyTreeIterator(List<FamilyTree> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    @Override
    public boolean hasNext() {
        return familyTreeList.size() > index;
    }

    @Override
    public FamilyTree next() {
        return familyTreeList.get(index++);
    }
}
