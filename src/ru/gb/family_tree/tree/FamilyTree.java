package ru.gb.family_tree.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import ru.gb.family_tree.item.FamilyTreeItem;
import ru.gb.family_tree.item.comparators.ItemComparatorByAge;
import ru.gb.family_tree.item.comparators.ItemComparatorByName;
import ru.gb.family_tree.item.comparators.ItemComparatorBySpouse;
import ru.gb.family_tree.tree.iterators.ItemIterator;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<FamilyTreeItem<E>> {
    private long itemID;
    private List<FamilyTreeItem<E>> itemList;

    public FamilyTree(List<FamilyTreeItem<E>> itemList) {
        this.itemList = itemList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
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
        for (FamilyTreeItem<E> parent : e.getParents()) {
            parent.addChild(e);
        }
    }

    private void addToChildren(E e) {
        for (FamilyTreeItem<E> child : e.getParents()) {
            child.addChild(e);
        }
    }

    public List<FamilyTreeItem<E>> getSiblings(long id) { // Поиск братьев и сестёр...
        FamilyTreeItem<E> e = getById(id);
        if (e == null) {
            return null;
        }
        List<FamilyTreeItem<E>> res = new ArrayList<>();
        for (FamilyTreeItem<E> parent : e.getParents()) {
            for (FamilyTreeItem<E> child : e.getChildren()) {
                if (!child.equals(e)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<FamilyTreeItem<E>> getByName(String name) {
        List<FamilyTreeItem<E>> res = new ArrayList<>();
        for (FamilyTreeItem<E> e : itemList) {
            res.add(e);
        }
        return res;
    }

    public boolean setWedding(long itemID1, long itemID2) {
        if (checkId(itemID1) && checkId(itemID2)) {
            FamilyTreeItem<E> e1 = getById(itemID1);
            FamilyTreeItem<E> e2 = getById(itemID2);
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
            FamilyTreeItem<E> e1 = getById(itemID1);
            FamilyTreeItem<E> e2 = getById(itemID2);
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
            FamilyTreeItem<E> e = getById(itemID);
            return itemList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < itemID && id >= 0;
    }

    public FamilyTreeItem<E> getById(long id) {
        for (FamilyTreeItem<E> e : itemList) {
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
        sb.append("В семейном древе ");
        sb.append(itemList.size());
        sb.append(" объектов: \n\n");
        for (FamilyTreeItem<E> e : itemList) {
            sb.append(e);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<FamilyTreeItem<E>> iterator() {
        return new ItemIterator<E>(itemList);
    }

    @SuppressWarnings("unchecked")
    public void sortByName() {
        itemList.sort((Comparator<? super FamilyTreeItem<E>>) new ItemComparatorByName<E>());
    }

    @SuppressWarnings("unchecked")
    public void sortByAge() {
        itemList.sort((Comparator<? super FamilyTreeItem<E>>) new ItemComparatorByAge<E>());
    }

    @SuppressWarnings("unchecked")
    public void sortBySpouse() {
        itemList.sort((Comparator<? super FamilyTreeItem<E>>) new ItemComparatorBySpouse<E>());
    }
}
