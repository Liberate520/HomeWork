package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

public class Tree<T extends Serializable> implements Serializable, Iterable<T> {
    private List<T> nodes;

    public Tree() {
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

