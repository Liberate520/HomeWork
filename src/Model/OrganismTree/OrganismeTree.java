package Model.OrganismTree;
import Model.Organisms.Organism;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class OrganismeTree<T extends Organism> implements Serializable, Iterable<T> {
    protected String familyName;
    protected ArrayList<T> tree;
    public void addPers(T somePers) {
        this.tree.add(somePers);
    }
    public T getByIndex(int index) {
        return tree.get(index);
    }

    public HashMap<Integer, String> getAllIndices() {
        HashMap <Integer, String> indices = new HashMap<Integer, String>();
        for (int i = 0; i < tree.size(); i++){
            indices.put(i, tree.get(i).getName());
        }
        return indices;
    }
}
