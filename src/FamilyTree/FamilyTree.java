package FamilyTree;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.io.Serializable;

public class FamilyTree<T extends HasId & HasChildren<T>> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private Map<Integer, T> elements;

    // Конструктор класса FamilyTree
    public FamilyTree() {
        this.elements = new HashMap<>();
    }

    // Метод для добавления элемента в дерево
    public void addElement(T element) {
        elements.put(element.getId(), element);
    }

    // Метод для получения элемента по ID
    public T getElement(int id) {
        return elements.get(id);
    }

    // Метод для получения детей элемента по ID
    public List<T> getChildren(int id) {
        T element = elements.get(id);
        return (element != null) ? element.getChildren() : new ArrayList<>();
    }

    public void printTree() {
        for (T element : elements.values()) {
            System.out.println(element);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return elements.values().iterator();
    }

    public void sortByName() {
        List<T> elementList = new ArrayList<>(elements.values());
        elementList.sort(Comparator.comparing(T::getName));
        elements.clear();
        for (T element : elementList) {
            elements.put(element.getId(), element);
        }
    }

    public void sortByBirthDate() {
        List<T> elementList = new ArrayList<>(elements.values());
        elementList.sort(Comparator.comparing(T::getBirthDate));
        elements.clear();
        for (T element : elementList) {
            elements.put(element.getId(), element);
        }
    }
}
