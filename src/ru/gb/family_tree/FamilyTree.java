package ru.gb.family_tree;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class FamilyTree implements Iterable<Node> {
    private List<Node> nodeList;
    private IOOperations ioOperations;

    public FamilyTree() {
        this.nodeList = new ArrayList<>();
        this.ioOperations = new FileIO();
    }

    public void addNode(Node node) {
        node.setId(nodeList.size());
        nodeList.add(node);
    }

    public void saveTreeToFile(String filename) throws IOException {
        ioOperations.saveTree(nodeList, filename);
    }

    public void loadTreeFromFile(String filename) throws IOException, ClassNotFoundException {
        this.nodeList = ioOperations.loadTree(filename);
    }

    public void printTree() {
        for (Node node : nodeList) {
            System.out.println(node);
        }
    }

    @Override
    public Iterator<Node> iterator() {
        return nodeList.iterator();
    }

    // Метод для сортировки списка узлов по имени
    public void sortByName() {
        Collections.sort(nodeList, (node1, node2) -> node1.getName().compareTo(node2.getName()));
    }

    // Метод для сортировки списка узлов по дате рождения
    public void sortByBirthDate() {
        Collections.sort(nodeList, (node1, node2) -> node1.getBirthDate().compareTo(node2.getBirthDate()));
    }
}