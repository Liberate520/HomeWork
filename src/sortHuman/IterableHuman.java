package sortHuman;

import human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableHuman implements Iterable<Human>{
    private List<Human> humanList;

    public IterableHuman() {
       humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        if (!humanList.contains(human)) {
            humanList.add(human);
        }
    }

    @Override
    public Iterator<Human> iterator() {
        return new IteratorForHuman(humanList);
    }
}
