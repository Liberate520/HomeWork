package family_tree.util;


import family_tree.person.Person;
import family_tree.view.FamilyTreeViewImpl;
import org.w3c.dom.Node;

import java.io.Serializable;
import java.util.*;

public class GenealogyTree<T> implements Serializable, Iterable<T> {
    private final Map<Integer, T> elements;
    private Node root;

     public Node getRoot() {
        return root;
    }

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

public void removeElement(int id) {
    elements.remove(id);
}

private void displayFamilyTree(GenealogyTree<Person> tree) {
    // Выводим информацию о корне дерева (обычно это старший предок)
    Person root = (Person) tree.getRoot();
    displayPerson(root);

    // Рекурсивно выводим информацию о детях корня
    displayChildren(root);
}

private void displayPerson(Person person) {
    System.out.println(person);
}

private void displayChildren(Person parent) {
    // Получаем список детей у родителя
    List<Person> children = parent.getChildren();

    // Выводим информацию о каждом ребенке
    for (Person child : children) {
        displayPerson(child);

        // Если у ребенка есть супруг(а), выводим информацию о нем/ней
        if (child.getSpouse() != null) {
            displayPerson(child.getSpouse());
        }

        // Рекурсивно вызываем этот метод для детей текущего ребенка
        displayChildren(child);
    }
}
//Этот код рекурсивно проходит по дереву, начиная с

}
