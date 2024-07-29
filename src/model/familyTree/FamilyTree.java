package model.familyTree;

import model.Human.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemFamilyTree> implements Serializable, Iterable<E> {
    List<E> family;

    public FamilyTree(){
        family = new ArrayList<E>();
    }

    public void addPerson(E human){
        family.add(human);
    }

    public E getPerson(String name){
        for(E person: family){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public void sortByName(){
        family.sort(new HumanComparatorByName<E>());
    }

    public void sortByAge(){
        family.sort(new HumanComparatorByAge<E>());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи: \n");
        for(E person : family){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator iterator() {
        return new ItemFamilyIterator(family);
    }

}
