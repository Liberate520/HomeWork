package ru.gb.family_tree;

import ru.gb.family_tree.iterators.FamilyTreeIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree<T> implements Iterable<T>, Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Добавление члена семьи
    public void addMember(T member) {
        this.members.add(member);
    }

    // Получение всех детей выбранного человека в виде поддерева
    public FamilyTree<T> getChildren(T member) {
        FamilyTree<T> subtree = new FamilyTree<>();
        if (member instanceof Human) {
            addChildrenRecursively(subtree, (Human) member);
        }
        return subtree;
    }

    // Рекурсивное добавление детей и их потомков в поддерево
    private void addChildrenRecursively(FamilyTree<T> subtree, Human human) {
        for (Human child : human.getChildren()) {
            subtree.addMember((T) child);
            addChildrenRecursively(subtree, child);
        }
    }

    // Поиск человека по полному имени (для удобства)
    public T findByFullName(String fullName) {
        for (T member : members) {
            if (member instanceof Human) {
                Human human = (Human) member;
                if (human.getFullName().equalsIgnoreCase(fullName)) {
                    return member;
                }
            }
        }
        return null;
    }

    // Получение всех членов семьи
    public List<T> getMembers() {
        return members;
    }

    // Сортировка по имени
    public void sortByName() {
        members.sort(Comparator.comparing(member -> {
            if (member instanceof Human) {
                return ((Human) member).getFullName();
            }
            return member.toString();
        }));
    }

    // Сортировка по дате рождения
    public void sortByBirthDate() {
        members.sort(Comparator.comparing(member -> {
            if (member instanceof Human) {
                return ((Human) member).getBirthDate();
            }
            return null;
        }));
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
