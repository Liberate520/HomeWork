package homeWork.familyTree;

import java.util.Iterator;
import java.util.List;
import homeWork.human.Human;

public class FamilyTreeIterator implements Iterator<Human>{
    private int index;
    private List<Human> list;

    public FamilyTreeIterator(List<Human> list){
        this.list=list;
    }

    @Override
    public boolean hasNext(){
        return index < list.size();
    }

    @Override
    public Human next(){
        return list.get(index++);
    }
}
