package family_tree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree = new ArrayList<>();

    @Override
    public String toString() {
        return printList(familyTree);
    }

    public void add(Human human) {
        familyTree.add(human);
    }

    public List<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public List<Human> findByName(String name) {
        return familyTree.stream()
                .filter(h -> h.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public void sortByName() {
        Collections.sort(familyTree);
    }

    public void sortByBirthDate() {
        familyTree.sort(Comparator.comparing(Human::getBirthdate));
    }

    /**
     * Сортировка по возрасту (с учетом даты смерти) по убыванию.
     */
    public void sortByAge() {
        familyTree.sort(Comparator.comparing(Human::getAge).reversed());
    }

    public String printList(List<Human> list) {
        return list.stream()
                .map(Human::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Iterator<Human> iterator() {
        return familyTree.iterator();
    }
}
