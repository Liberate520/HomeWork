
package ru.gb.family_tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import ru.gb.family_tree.iterators.FamilyTreeIterator;


public class FamilyTree<T> implements Iterable<T>, Serializable {
    private List<T> members;
    private Function<T, List<T>> childrenExtractor; // Функция для извлечения потомков

    public FamilyTree(Function<T, List<T>> childrenExtractor) {
        this.members = new ArrayList<>();
        this.childrenExtractor = childrenExtractor;
    }

    // Добавление члена дерева
    public void addMember(T member) {
        this.members.add(member);
    }

    // Получение всех потомков выбранного объекта в виде поддерева
    public FamilyTree<T> getChildren(T member) {
        FamilyTree<T> subtree = new FamilyTree<>(childrenExtractor);
        addChildrenRecursively(subtree, member);
        return subtree;
    }

    // Рекурсивное добавление потомков в поддерево
    private void addChildrenRecursively(FamilyTree<T> subtree, T member) {
        List<T> children = childrenExtractor.apply(member);
        for (T child : children) {
            subtree.addMember(child);
            addChildrenRecursively(subtree, child);
        }
    }

    // Поиск объекта по определенному критерию (например, по имени)
    public T findByCriterion(Function<T, Boolean> criterion) {
        for (T member : members) {
            if (criterion.apply(member)) {
                return member;
            }
        }
        return null;
    }

    // Получение всех членов дерева
    public List<T> getMembers() {
        return members;
    }

    // Сортировка по определенному критерию
    public void sortByCriterion(Comparator<T> comparator) {
        members.sort(comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(members);
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "members=\n" + members.stream()
                                     .map(Object::toString)
                                     .collect(Collectors.joining("\n")) +
                '}';
    }
}
