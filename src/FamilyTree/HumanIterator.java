package src.FamilyTree;

import java.util.Iterator;
import java.util.List;

import src.Human.Human;

public class HumanIterator implements Iterator <Human> {
    private int CurrentID;
    private List<Human> members;

    public HumanIterator(List<Human> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return members.size() > CurrentID;
    }

    @Override
    public Human next() {
       return members.get(CurrentID++);
    }
}
