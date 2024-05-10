package re.zip.famely_tree.model.famely_tree.iterators;

import java.util.Iterator;
import java.util.List;
import re.zip.famely_tree.model.famely_tree.FamelyTreeElement;

public class FamelyTreeElementIterator<T extends FamelyTreeElement<T>> implements Iterator<T>{
    
    private int index;
    private final List<T> humanList;

    public FamelyTreeElementIterator(List<T> humanList){
        this.humanList = humanList;
    }
    
    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }
    
    @Override
    public T next() {
        return humanList.get(index++);
    }
}
