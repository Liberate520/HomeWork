package family_tree;

import man.Man;

import java.util.Iterator;
import java.util.List;

public class ManIterator implements Iterator<Man> {
    private int index;
    private List<Man> manList;
    public ManIterator(List<Man> manList){
        this.manList = manList;
    }

    @Override
    public boolean hasNext() {
        return index<manList.size();
    }

    @Override
    public Man next() {
        return manList.get(index++);
    }
}
