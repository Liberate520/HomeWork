package ru.gb.family_tree.model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.gb.family_tree.model.item.FamilyTreeItem;
import ru.gb.family_tree.model.item.comparators.ItemComparatorByAge;
import ru.gb.family_tree.model.item.comparators.ItemComparatorByName;
import ru.gb.family_tree.model.item.comparators.ItemComparatorBySpouse;
import ru.gb.family_tree.model.tree.iterators.ItemIterator;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private long itemID;
    private List<E> itemList;

    public FamilyTree() {
        this(new ArrayList<>());
    }    

    public FamilyTree(List<E> itemList) {
        this.itemList = itemList;
    }

    public boolean add(E familyTreeItem) {
        if (familyTreeItem == null) {
            return false;
        }
        if (!itemList.contains(familyTreeItem)) { // Не очень удачное решение, потому что id присваивается ниже
            itemList.add(familyTreeItem);
            familyTreeItem.setId(itemID++);

            addToParents(familyTreeItem);
            addToChildren(familyTreeItem);

            return true;
        }
        return false;
    }

    private void addToParents(E e) {
        for (E parent : e.getParents()) {
            parent.addChild(e);
        }
    }

    private void addToChildren(E e) {
        for (E child : e.getParents()) {
            child.addChild(e);
        }
    }

    public List<E> getSiblings(long id) { // Поиск братьев и сестёр...
        E e = getById(id);
        if (e == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : e.getParents()) {
            for (E child : e.getChildren()) {
                if (!child.equals(e)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E e : itemList) {
            res.add(e);
        }
        return res;
    }

    public boolean setWedding(long itemID1, long itemID2) {
        if (checkId(itemID1) && checkId(itemID2)) {
            E e1 = getById(itemID1);
            E e2 = getById(itemID2);
            if (e1.getSpouse() == null && e2.getSpouse() == null) {
                e1.setSpouse(e2);
                e2.setSpouse(e1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDivorce(long itemID1, long itemID2) {
        if (checkId(itemID1) && checkId(itemID2)) {
            E e1 = getById(itemID1);
            E e2 = getById(itemID2);
            if (e1.getSpouse() != null && e2.getSpouse() != null) {
                e1.setSpouse(null);
                e2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long itemID) {
        if (checkId(itemID)) {
            E e = getById(itemID);
            return itemList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < itemID && id >= 0;
    }

    public E getById(long id) {
        for (E e : itemList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Всего объектов в семейном древе - ");
        sb.append(itemList.size());
        sb.append("\n\n");
        for (E e : itemList) {
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ItemIterator<>(itemList);
    }

    public void sortByName() {
        itemList.sort(new ItemComparatorByName<>());
    }

    public void sortByAge() {
        itemList.sort(new ItemComparatorByAge<>());
    }

    public void sortBySpouse() {
        itemList.sort(new ItemComparatorBySpouse<>());
    }
}
