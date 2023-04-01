package geotree;

import person.Person;
import person.PersonComparatorByAge;
import person.PersonComparatorByName;
import person.PersonIterator;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GeoTree implements Serializable, Iterable<Person> {

    private ArrayList<Person> tree = new ArrayList<>();

    public ArrayList<Person> getTree() {
        return tree;
    }

    public void appendPerson(Person person) {
            tree.add(person);
    }
    public void autoAppendChildren(){
        for (Person p:tree) {
            if (p.getMother()!=null){
                p.getMother().addChild(p);
            }
            if (p.getFather()!=null){
                p.getFather().addChild(p);
            }
        }
    }

    public void save(write saveGeo) throws IOException{
        saveGeo.write(this);
    }

    public void restore(read restoreGeo) throws IOException, ClassNotFoundException {
        restoreGeo.read();
    }

    @Override
    public Iterator<Person> iterator(){
        return new PersonIterator(tree);
    }
    public void sortByAge() {
        tree.sort(new PersonComparatorByAge());
    }
    public void sortByName() {
        tree.sort(new PersonComparatorByName());
    }

}