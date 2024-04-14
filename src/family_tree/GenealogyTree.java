package family_tree;


import family_tree.person.Person;

import java.io.Serializable;
import java.util.*;

public class GenealogyTree<T> implements Serializable, Iterable<T> {
    private final Map<Integer, T> elements;

    public GenealogyTree() {
        this.elements = new HashMap<>();
    }

    public T findById(int id) {
        return elements.getOrDefault(id, null);
    }

    public void displayInfo(int id) {
        T element = findById(id);
        if (element != null) {
            System.out.println("id: " + id + ", " + element.toString());
        } else {
            System.out.println("Элемент с id " + id + " не найден.");
        }
    }

    public void addElement(int id, T element) {
        elements.put(id, element);
    }

    public Collection<T> getAllElements() {
        return elements.values();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.values().iterator();
    }

    // Метод сортировки списка элементов по имени (если объекты имеют метод getName())
  public List<T> sortByName(Collection<T> elements) {
    List<T> sortedList = new ArrayList<>(elements);
    sortedList.sort(Comparator.comparing(o -> ((Person) o).getName()));
    return sortedList;
}

    // Метод сортировки списка элементов по возрасту (если объекты имеют метод getAge())
   public List<T> sortByAge(Collection<T> elements) {
    List<T> sortedList = new ArrayList<>(elements);
    sortedList.sort(Comparator.comparingInt(o -> ((Person) o).getAge()));
    return sortedList;
}
}
