package model;
import Presenter.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class FamilyTree<T extends Node> implements Iterable<T> {
    private List<T> nodeList;
    private IOOperations<T> ioOperations;

    public FamilyTree() {
        this.nodeList = new ArrayList<>();
        this.ioOperations = new FileIO<>();
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

    public void saveTreeToFile(String filename) throws IOException {
        ioOperations.saveTree(nodeList, filename);
    }

    public void loadTreeFromFile(String filename) throws IOException, ClassNotFoundException {
        this.nodeList = ioOperations.loadTree(filename);
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
}
