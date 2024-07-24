package FamilyTree;

import java.util.*;
import java.io.Serializable;

public class FamilyTree<T extends HasId & HasChildren<T>> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> elements;
    private int nextId = 1;

    public FamilyTree() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
        if (element.getId() >= nextId) {
            nextId = element.getId() + 1;
        }
    }

    public T getElement(int id) {
        for (T element : elements) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public List<T> getChildren(int id) {
        T element = getElement(id);
        return (element != null) ? element.getChildren() : new ArrayList<>();
    }

    public List<T> getAllElements() {
        return new ArrayList<>(elements);
    }

    public int getNextId() {
        return nextId;
    }

    public void clear() {
        elements.clear();
    }

    public T findByName(String name) {
        return elements.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public void sortByName() {
        elements.sort(Comparator.comparing(T::getName));
    }

    public void sortByBirthDate() {
        elements.sort(Comparator.comparing(T::getBirthDate));
    }

    public void sortByAge() {
        elements.sort(Comparator.comparing(T::getAge));
    }
}