package FamilyTree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human>{

    private int index;
    private List<Human> familyTree;

    public FamilyTreeIterator(List<Human> familyTree){
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public Human next() {
        return familyTree.get(index++);
    }
}
