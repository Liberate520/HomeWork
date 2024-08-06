package family_tree;

import java.io.Serializable;
import java.util.*;
import family_tree.*;

class HumanIterator <T> implements Iterator<T>, Serializable{
    private int curIndex;
    private List <T> tree;

    @Override
    public boolean hasNext(){
        return tree.size()>curIndex;
    }
    
    @Override
    public T next(){
        return tree.get(curIndex++);
    }
        
}