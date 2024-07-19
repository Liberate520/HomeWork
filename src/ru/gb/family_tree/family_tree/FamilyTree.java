package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.iterator.FamilyTreeIterator;
import ru.gb.family_tree.comparators.ItemComparatorByAge;
import ru.gb.family_tree.comparators.ItemComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ElementFamilyTree<E>> implements Serializable, Iterable<E> {
    private List<E> elements;

    public FamilyTree() {
        elements = new ArrayList<>();
    }

    public E getReadName(String nameElement) {
        for (E element : elements) {
            if (element.getName().equals(nameElement)) {
                return element;
            }
        }
        return null;
    }

    public void addElement(E element) {
        elements.add(element);
    }

    public List<E> getElements() {
        return elements;
    }

    public void sortByName() {
        Collections.sort(elements, new ItemComparatorByName<>());
    }

    public void sortByAge() {
        Collections.sort(elements, new ItemComparatorByAge<>());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список элементов:");
        for (E element : elements) {
            stringBuilder.append("\n\n");
            stringBuilder.append(element.getBasicInfo());
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(elements);
    }
}
