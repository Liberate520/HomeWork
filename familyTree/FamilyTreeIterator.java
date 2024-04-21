package homeWork.familyTree;

import java.util.Iterator;
import java.util.List;
//import homeWork.human.Human;

public class FamilyTreeIterator<T extends FamTree> implements Iterator<T>{
    private int index;
    private List<T> list;

    public FamilyTreeIterator(List<T> list){
        this.list=list;
    }

    @Override
    public boolean hasNext(){
        return index < list.size();
    }

    @Override
    public T next(){
        return list.get(index++);
    }
}
