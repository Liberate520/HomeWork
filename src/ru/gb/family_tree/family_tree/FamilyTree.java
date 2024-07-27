package ru.gb.family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long humansId; // Идентификатор для людей в древе
    private final List<E> humanList; // Список людей в древе

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human) {
        if (human == null) {
            return false; // Проверка на null
        }
        if (!humanList.contains(human)) {
            human.setId(humansId++); // Увеличение ID происходит перед добавлением
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false; // Возвращаем false, если человек уже существует
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);
        if (human == null) {
            return null; // Если человек не найден, возвращаем null
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res; // Возвращаем список братьев и сестер
    }

    public List<E> getByName(String name) {
        if (name == null) { // Проверка на null для имени
            return new ArrayList<>(); // Возвращаем пустой список, если имя null
        }
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (name.equals(human.getName())) {
                res.add(human);
            }
        }
        return res;
    }

    private boolean checkId(long id) {
        return id < humansId && id >= 0; // Проверка, существует ли ID
    }

    public E getById(long id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human; // Возвращаем человека по ID
            }
        }
        return null; // Если не найдено, возвращаем null
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В древе");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        humanList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByDeathDate() {
        humanList.sort(new FamilyTreeComparatorByBirthDate<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator(humanList);
    }

}