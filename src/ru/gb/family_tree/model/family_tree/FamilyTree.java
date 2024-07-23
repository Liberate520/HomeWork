package ru.gb.family_tree.model.family_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends ElementFamilyTree<T>> implements Iterable<T> {
    private List<T> elements;

    public FamilyTree() {
        elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void sortByName() {
        Collections.sort(elements);
    }

    public void sortByAge() {
        elements.sort((e1, e2) -> e1.getBirthDate().compareTo(e2.getBirthDate()));
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
