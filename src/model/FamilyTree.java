package model;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FamilyTree<T extends Node> implements Iterable<T> {
    private List<T> nodeList;

    public FamilyTree() {
        this.nodeList = new ArrayList<>();
    }

    public void addNode(T node) {
        node.setId(nodeList.size());
        nodeList.add(node);
    }

    public boolean removeNode(String name) {
        Iterator<T> iterator = nodeList.iterator();
        while (iterator.hasNext()) {
            T node = iterator.next();
            if (node.getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void printTree() {
        for (T node : nodeList) {
            System.out.println(node);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return nodeList.iterator();
    }

    public void sortByName() {
        Collections.sort(nodeList, (node1, node2) -> node1.getName().compareTo(node2.getName()));
    }

    public void sortByBirthDate() {
        Collections.sort(nodeList, (node1, node2) -> node1.getBirthDate().compareTo(node2.getBirthDate()));
    }

    public List<T> getNodes() {
        return nodeList;
    }
}