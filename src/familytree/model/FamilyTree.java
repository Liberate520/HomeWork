package familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Serializable> implements Serializable, Iterable<T> {
    private List<T> nodes;

    public FamilyTree() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(T node) {
        this.nodes.add(node);
    }

    public List<T> getNodes() {
        return nodes;
    }

    @Override
    public Iterator<T> iterator() {
        return nodes.iterator();
    }

    public void sortBy(Comparator<T> comparator) {
        Collections.sort(nodes, comparator);
    }
}
