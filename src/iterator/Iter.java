package src.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import src.Human;



public class Iter implements Iterator<Human> {

    private Integer index;

    private ArrayList<Human> arr = new ArrayList<>();

    public Iter(ArrayList<Human> arr){
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return index<arr.size()-1;
        
    }

    @Override
    public Human next() {
        return arr.get(index++);
    }
    
}
