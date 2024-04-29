package src.model;

import java.util.Iterator;
import java.util.List;



public class PersonIterator<E extends FamilyObject<E>> implements Iterator<E> {
    
    private List<E> listPersons;

    private int index;

    public PersonIterator (List<E> listPersons){
        this.listPersons=listPersons;
    }
    @Override
    public boolean hasNext(){
        return index < listPersons.size();
    }
    @Override
    public E next(){
        return listPersons.get(index++);
    }
}
