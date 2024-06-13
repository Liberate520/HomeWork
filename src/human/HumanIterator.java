package human;


import java.util.*;

public class HumanIterator implements Iterator<Human>{
    private int currentId;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }


    @Override
    public boolean hasNext() {
        return humanList.size() > currentId;
    }

    @Override
    public Human next() {
        return humanList.get(currentId++);
    }
}