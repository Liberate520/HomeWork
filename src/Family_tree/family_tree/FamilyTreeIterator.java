package Family_tree.family_tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeTop<T>> implements Iterator<T> {
    private List<T> List;
    private  int index;

    public FamilyTreeIterator(List<T> list) {
        this.List = list;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return index < List.size();
    }

    @Override
    public T next() {
        return List.get(index++);
    }








}