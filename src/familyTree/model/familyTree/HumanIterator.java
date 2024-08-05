package familyTree.model.familyTree;
import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeItem<T>> implements Iterator<T> {

    private int countIndex;
    private List<T> familyTree;

    public HumanIterator(List<T> familyTree){
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > countIndex;
    }

    @Override
    public T next() {
        return familyTree.get(countIndex++);
    }
}