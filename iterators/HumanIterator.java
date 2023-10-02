package iterators;

import java.util.Iterator;
import java.util.List;

import members.Human;

public class HumanIterator implements Iterator<Human>{
    private int index;
    private List<Human> humanList;
    public HumanIterator(List<Human> humanList){
        this.humanList = humanList;
    }
    @Override
    public boolean hasNext(){
        return humanList.size() > index;
    }

    @Override
    public Human next(){
        return humanList.get(index++);
    }
}
