package OrganismTree.PersonsTree;

import OrganismTree.OrganismeTree;
import Organisms.Mammals.Persons.Comporators.ComporatorByName;
import Organisms.Mammals.Persons.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Person> extends OrganismeTree<T> {


    //конструкторы
    public FamilyTree (String familyName) {
        this.familyName = familyName;
        tree = new ArrayList<T>();
    }
    public FamilyTree() {
        this("default");
    }

    //методы

    public String getAllFamily() {
        String out = "";
        for (T somePers : tree) {
            out += somePers;
        }
        return out;
    }
    public String getFullPerson (String name) {
        for (T somePers : tree) {
            if (somePers.getName() == name)
                return somePers.toString();
        }
        return "";
    }
    public String getPersonOnSurname (String name) {
        for (T somePers : tree) {
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
                Comparator.comparing(T::getBirthday));
                //(o1, o2) -> o1.getBirthday().compareTo(o2.getBirthday());
    }
}
