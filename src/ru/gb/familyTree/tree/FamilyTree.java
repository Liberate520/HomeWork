package ru.gb.familyTree.tree;

import ru.gb.familyTree.exceptions.TreeExceptions;
import ru.gb.familyTree.person.Person;
import ru.gb.familyTree.person.PersonBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FamilyTree {
    private String family;
    private Person root;
    private List<Node> nodeList = new ArrayList<>();

    public FamilyTree(String family, Person root, List<Node> nodes) {
        this.setFamily(family);
        this.setRoot(root);
        this.setNode(nodes);
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setRoot(Person root) {
        this.root = root;
    }

    public void setNode(List<Node> node) {
        this.nodeList = node;
    }

    public boolean addNode(Node node){
        Node temp = new NodeBuilder().createNode();
        temp.setFamily(node.getFamily()); temp.setId(node.getId());
        temp.setParentOne(node.getParentOne()); temp.setParentTwo(node.getParentTwo());
        temp.setChildren(node.getChildren());
        return nodeList.add(temp);
    }
    public Node getObjectById (int id){
        for (Node itm: nodeList) {
            if (itm.getId() == id) return itm;
        }
        return null;
    }

    public String getFamily() {
        return family;
    }

    public Person getRoot() {
        return root;
    }

    public List<Node> getNode() {
        return nodeList;
    }
}