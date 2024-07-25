package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends ElementFamilyTree<T>> implements Serializable, Iterable<T>{

    private List<T> elements;
    private Map<String, T> nameMap;

    public FamilyTree() {
        elements = new ArrayList<>();
        nameMap = new HashMap<>();
    }

    public void addElement(T element) {
        elements.add(element);
        nameMap.put(element.getName(), element);
    }

    public T getMember(String name) {
        return nameMap.get(name);
    }

    public void sortByName() {
        Collections.sort(elements);
    }

    public void sortByAge() {
        elements.sort((e1, e2) -> e1.getBirthDate().compareTo(e2.getBirthDate()));
    }


    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
