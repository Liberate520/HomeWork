package Model.FamilyTree.Iterators;

import java.util.Iterator;
import java.util.List;

import Model.Human.Human;

public class FamilyTreeIterator<E> implements Iterator<E>{
    private int index;
    private List<E> family;

    public FamilyTreeIterator(List<E> family){
        this.family = family;
    }

    @Override
    public boolean hasNext(){
        return index<family.size();
    }

    @Override
    public E next(){
        return family.get(index++);
    }
}
