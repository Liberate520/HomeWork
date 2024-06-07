package PersonsTree;

import Organisms.Mammals.Persons.Comporators.ComporatorByName;
import Organisms.Mammals.Persons.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Person> {
    private String familyName;
    private ArrayList<Person> tree;


    //конструкторы
    public FamilyTree (String familyName) {
        this.familyName = familyName;
        tree = new ArrayList<Person>();
    }
    public FamilyTree() {
        this("default");
    }

    //методы
    public void addPers(Person somePers) {
        this.tree.add(somePers);
    }
    public String getAllFamily() {
        String out = "";
        for (Person somePers : tree) {
            out += somePers;
        }
        return out;
    }
    public String getFullPerson (String name) {
        for (Person somePers : tree) {
            if (somePers.getName() == name)
                return somePers.toString();
        }
        return "";
    }
    public String getPersonOnSurname (String name) {
        for (Person somePers : tree) {
            if (somePers.getName().split(" ")[0].equals(name))
                return somePers.toString();
        }
        return "";
    }
    @Override
    public Iterator iterator() {
        return tree.iterator();
    }

    public void sortByName() {
        Collections.sort(tree, new ComporatorByName());
    }
    public void sortByBirthday() {
        Collections.sort(tree,
                Comparator.comparing(Person::getBirthday));
                //(o1, o2) -> o1.getBirthday().compareTo(o2.getBirthday());
    }
}
