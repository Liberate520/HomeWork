package FamilyTree.iterator;

import FamilyTree.model.Human;
import FamilyTree.model.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> members;
    private int currentIndex;

    public FamilyTreeIterator(FamilyTree familyTree) {
        this.members = familyTree.getMembers();
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < members.size();
    }

    @Override
    public Human next() {
        return members.get(currentIndex++);
    }
}