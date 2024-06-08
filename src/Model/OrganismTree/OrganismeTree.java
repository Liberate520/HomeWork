package OrganismTree;

import Organisms.Mammals.Persons.Person;
import Organisms.Organism;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class OrganismeTree<T extends Organism> implements Serializable, Iterable<T> {
    protected String familyName;
    protected ArrayList<T> tree;
    public void addPers(T somePers) {
        this.tree.add(somePers);
    }
}
