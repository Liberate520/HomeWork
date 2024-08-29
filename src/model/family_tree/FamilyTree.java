package model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    @Override
    public String toString() {
        return printList(familyTree);
    }

    public void add(E item) {
        familyTree.add(item);
    }

    public List<E> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public List<E> findByName(String name) {
        return familyTree.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public E findById(int id) {
        return familyTree.stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElse(null);
    }

    public void sortByName() {
        Collections.sort(familyTree);
    }

    public void sortByBirthDate() {
        familyTree.sort(Comparator.comparing(E::getBirthDate));
    }

    /**
     * Сортировка по возрасту (с учетом даты смерти).
     */
    public void sortByAge() {
        familyTree.sort(Comparator.comparing(E::getAge));
    }

    public String printList(List<E> list) {
        return list.stream()
                .map(E::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Iterator<E> iterator() {
        return familyTree.iterator();
    }
}
