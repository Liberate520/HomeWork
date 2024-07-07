package FamilyTree;

import java.util.Iterator;
import java.util.List;

import Humans.Human;
    
public class FamilyIterator implements Iterator<Human> {
    private int currentID;
    private List<Human> humans;
    
    public FamilyIterator(List<Human> humans) {
        this.humans = humans;
        }
    
        @Override
        public boolean hasNext() {
            return humans.size() > currentID;
        }
    
        @Override
        public Human next() {
            return humans.get(currentID++);
        }
    
}
