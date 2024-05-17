package Family_Tree.model.FamilyTree;



import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends TreeVersatility<T>> implements Iterator<T> {
    private int index;
    private List<T> HumanList;

    public HumanIterator(List<T> humanList) {
        this.HumanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index<HumanList.size();
    }

    @Override
    public T next() {
        return HumanList.get(index++);
    }
}



