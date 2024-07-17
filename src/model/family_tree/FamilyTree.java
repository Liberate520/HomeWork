package model.family_tree;

import model.family_tree.family_tree_manager.FamilyTreeRelationshipManager;
import model.family_tree.family_tree_manager.FamilyTreeSiblingsManager;
import model.family_tree.family_tree_manager.FamilyTreeSpouseManager;
import model.iterators.FamilyTreeIterator;
import model.comparators.HumansComparatorByBirthDate;
import model.comparators.HumansComparatorById;
import model.comparators.HumansComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private List<E> nodeList;
    private FamilyTreeRelationshipManager<E> familyTreeRelationshipManager;
    private FamilyTreeSpouseManager<E> familyTreeSpouseManager;
    private FamilyTreeSiblingsManager<E> familyTreeSiblingsManager;

    public FamilyTree(List<E> nodeList) {
        this.nodeList = nodeList;
        this.familyTreeRelationshipManager = new FamilyTreeRelationshipManager<>();
        this.familyTreeSpouseManager = new FamilyTreeSpouseManager<>();
        this.familyTreeSiblingsManager = new FamilyTreeSiblingsManager<>();
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(E node) {
        if (node == null) {
            return false;
        }
        if (!nodeList.contains(node)) {
            nodeList.add(node);
            int id = getMaxId();
            node.setId(++id);
            familyTreeRelationshipManager.updateRelationships(node);
            return true;
        }
        return false;
    }

    public boolean remove(int nodeId) {
        if (checkId(nodeId)) {
            E node = getById(nodeId);
            return nodeList.remove(node);
        }
        return false;
    }

    public E getById(int id) {
        for (E node : nodeList) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E node : nodeList) {
            if (node.getName().equals(name)) {
                res.add(node);
            }
        }
        return res;
    }

    public List<E> getSiblings(int id) {
        E node = getById(id);
        return familyTreeSiblingsManager.getSiblings(node);
    }

    public boolean setWedding(int nodeId1, int nodeId2) {
        if (checkId(nodeId1) && checkId(nodeId2)) {
            E node1 = getById(nodeId1);
            E node2 = getById(nodeId2);
            return familyTreeSpouseManager.setWedding(node1, node2);
        }
        return false;
    }

    public boolean setDivorce(int nodeId1, int nodeId2) {
        if (checkId(nodeId1) && checkId(nodeId2)) {
            E node1 = getById(nodeId1);
            E node2 = getById(nodeId2);
            return familyTreeSpouseManager.setDivorce(node1, node2);
        }
        return false;
    }

    public void sortByBirthDate() {
        nodeList.sort(new HumansComparatorByBirthDate<>());
    }

    public void sortByName() {
        nodeList.sort(new HumansComparatorByName<>());
    }

    public void sortById() {
        nodeList.sort(new HumansComparatorById<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(nodeList);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nВ дереве ").append(nodeList.size()).append(" объектов:\n");
        for (E node : nodeList) {
            sb.append(node).append("\n");
        }
        return sb.toString();
    }

    private int getMaxId() {
        int maxId = -1;
        for (E node : nodeList) {
            if (node.getId() > maxId) {
                maxId = node.getId();
            }
        }
        return maxId;
    }

    private boolean checkId(int id) {
        return id <= getMaxId() && id >= 0;
    }
}
