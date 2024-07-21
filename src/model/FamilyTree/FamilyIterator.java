package model.FamilyTree;

import java.util.Iterator;
import java.util.List;


    
public class FamilyIterator<U> implements Iterator<U> {
    private int currentID;
    private List<U> humans;
    
    public FamilyIterator(List<U> humans) {
        this.humans = humans;
        }
    
        @Override
        public boolean hasNext() {
            return humans.size() > currentID;
        }
    
        @Override
        public U next() {
            return humans.get(currentID++);
        }
    
}
