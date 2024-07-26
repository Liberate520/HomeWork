package model.familytree;

import model.compare_metods.CompareByBirthDate;
import model.compare_metods.CompareByID;
import model.compare_metods.CompareByName;
import model.familytree.familytree_relation.FamilyRelationShip;
import model.familytree.familytree_relation.MaritalRelations;
import model.familytree.familytree_relation.SiblingsRelations;
import model.iterator.TreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeNodes<T>> implements Serializable, Iterable<T> {

    private List<T> nodes;
    private FamilyRelationShip<T> familyRelationShip;
    private MaritalRelations<T> maritalRelations;
    private SiblingsRelations<T> siblingsRelations;

    public FamilyTree(List<T> nodes) {
        this.nodes = nodes;
        familyRelationShip = new FamilyRelationShip<>();
        maritalRelations = new MaritalRelations<>();
        siblingsRelations = new SiblingsRelations<>();
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(T node) {
        if (node == null) {
            return false;
        }
        if (!nodes.contains(node)) {
            nodes.add(node);
            int id = getMaxId();
            node.setId(++id);
            familyRelationShip.updateRelation(node);
            return true;
        }
        return false;
    }

    public void remove(int nodeId) {
        if (checkId(nodeId)) {
            T node = getById(nodeId);
            nodes.remove(node);
        }
    }

    public List<T> getSiblings(int id) {
        T node = getById(id);
        return siblingsRelations.getSiblings(node);
    }

    public List<T> getByName(String name) {
        List<T> result = new ArrayList<>();
        for (T node : nodes) {
            if (node.getName().equals(name)) {
                result.add(node);
            }
        }
        return result;
    }

    public String getTreeInfo() {
        StringBuilder result = new StringBuilder();
        result.append("В дереве ").append(nodes.size()).append(" человек. \n");
        for (T node : nodes) {
            result.append(node.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public boolean setMarried(int nodeId1, int nodeId2) {
        if (checkId(nodeId1) && checkId(nodeId2)) {
            T node1 = getById(nodeId1);
            T node2 = getById(nodeId2);
            return maritalRelations.setMarried(node1, node2);
        }
        return false;
    }

    public boolean setDivorced(int nodeId1, int nodeId2) {
        if (checkId(nodeId1) && checkId(nodeId2)) {
            T node1 = getById(nodeId1);
            T node2 = getById(nodeId2);
            return maritalRelations.setDivorced(node1, node2);
        }
        return false;
    }

    public void sortById() {
        nodes.sort(new CompareByID<>());
    }

    public void sortByBirthDate() {
        nodes.sort(new CompareByBirthDate<>());
    }

    public void sortByName() {
        nodes.sort(new CompareByName<>());
    }

    private int getMaxId() {
        int maxId = -1;
        for (T node : nodes) {
            if (node.getId() > maxId) {
                maxId = node.getId();
            }
        }
        return maxId;
    }

    public T getById(int id) {
        for (T node : nodes) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    private boolean checkId(int id) {
        return id >= 0 && id <= getMaxId();
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(nodes);
    }

    @Override
    public String toString() {
        return getTreeInfo();
    }
}