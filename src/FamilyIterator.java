import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator<Human> {
    private List<Human> list;
    private int index;

    public FamilyIterator(List<Human> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }

    @Override
    public Human next() {
        return list.get(index++);
    }
}
