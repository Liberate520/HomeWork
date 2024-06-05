package PersonsTree;

import Persons.Comporators.PersonComporatorByName;
import Persons.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable {
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
    public String getAllFamily() {
        String out = "";
        for (Person somePers : tree) {
            out += somePers;
        }
        return out;
    }
    public String getFullFamily() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : tree) {
            stringBuilder.append(person + "\n");
        }
        return stringBuilder.toString();
    }
    public String getFullPerson (String name) {
        for (Person somePers : tree) {
            if (somePers.getName() == name)
                return somePers.toString();
        }
        return "";
    }
    public String getPersonOnSurname (String name) {
        String out = "";
        for (Person somePers : tree) {
            //System.out.println(somePers.getName().split(" ")[0]);
            if (somePers.getName().split(" ")[0].equals(name))
                out += somePers;
        }
        return out;
    }
    public void addPers(Person somePers) {
        this.tree.add(somePers);
    }

    @Override
    public Iterator iterator() {
        return tree.iterator();
    }

    public void sortByName() {
        Collections.sort(tree, new PersonComporatorByName());
    }
    public void sortByBirthday() {
        Collections.sort(tree,
                Comparator.comparing(Person::getBirthday));
                //(o1, o2) -> o1.getBirthday().compareTo(o2.getBirthday());
    }
}
