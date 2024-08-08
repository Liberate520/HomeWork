
package com.familytree.model.family_tree;

import com.familytree.model.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> nodes;

    public FamilyTree() {
        this.nodes = new ArrayList<>();
    }

    public List<Human> getNodes() {
        return nodes;
    }

    public void addNode(Human node) {
        nodes.add(node);
    }

    public void sortByName() {
        nodes.sort(Comparator.comparing(Human::getName));
    }

    public void sortByBirthDate() {
        nodes.sort(Comparator.comparing(Human::getBirthDate));
    }

    @Override
    public Iterator<Human> iterator() {
        return nodes.iterator();
    }
}
