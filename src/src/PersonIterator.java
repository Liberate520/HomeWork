package src;

import java.util.Iterator;
import java.util.List;



public class PersonIterator implements Iterator<Person> {
    
    private List<Person> listPersons;

    private int index;

    public PersonIterator (List<Person> listPersons){
        this.listPersons=listPersons;
    }
    @Override
    public boolean hasNext(){
        return index < listPersons.size();
    }
    @Override
    public Person next(){
        return listPersons.get(index++);
    }
}
