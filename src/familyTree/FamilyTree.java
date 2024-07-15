package familyTree;

import Human.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    List<Human> family;

    public FamilyTree(){
        family = new ArrayList<>();
    }

    public void addPerson(Human human){
        family.add(human);
    }

    public Human getPerson(String name){
        for(Human person: family){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public void sortByName(){
        family.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        family.sort(new HumanComparatorByAge());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи: \n");
        for(Human person : family){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(family);
    }

}
