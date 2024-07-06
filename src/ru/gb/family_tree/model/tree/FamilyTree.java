package ru.gb.family_tree.model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.gb.family_tree.model.item.FamilyTreeItem;
import ru.gb.family_tree.model.item.comparators.ItemComparatorByAge;
import ru.gb.family_tree.model.item.comparators.ItemComparatorById;
import ru.gb.family_tree.model.item.comparators.ItemComparatorByName;
import ru.gb.family_tree.model.item.comparators.ItemComparatorBySpouse;
import ru.gb.family_tree.model.tree.iterators.ItemIterator;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private int itemID;
    private List<E> itemList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> itemList) {
        this.itemList = itemList;
    }

    private boolean isEquals(E e1, E e2) {
        String info1 = e1.getInfo().substring(e1.getInfo().indexOf(","));
        String info2 = e2.getInfo().substring(e2.getInfo().indexOf(","));
        return /*(e1.getId() == e2.getId()) && */
                // (e1.getName().equals(e2.getName())) &&
                // (e1.getBirthDate().equals(e2.getBirthDate())) &&
                // ((e1.getDeathDate() == e2.getDeathDate()) ||
                // (e1.getDeathDate().equals(e2.getDeathDate()))) &&
                // (e1.getGender() == e2.getGender()) &&
                // (e1.getChildren().equals(e2.getChildren())) &&
                // (e1.getFather() == e2.getFather()) &&
                // (e1.getMother() == e2.getMother()) &&
                // (e1.getParents() == e2.getParents()) &&
                // (e1.getSpouse().equals(e2.getSpouse()));
                (info1 == info2) || (info1.equals(info2));
    }


    public boolean add(E familyTreeItem) {
        if (familyTreeItem == null) {
            return false;
        }

        // familyTreeItem.setId(itemID++);

        // if (!itemList.contains(familyTreeItem)) { // Не очень удачное решение, потому
        // // что id присваивается ниже

        for (E e : itemList) {
            if (isEquals(e, familyTreeItem)) {
                return false;
            }
        }
        
        itemList.add(familyTreeItem);
        familyTreeItem.setId(itemID++);

        addToParents(familyTreeItem);
        addToChildren(familyTreeItem);

        return true;

        // return false;
    }

    public void addToParents(E e) {
        for (E parent : e.getParents()) {
            parent.addParent(e);
        }
    }

    public void addToChildren(E e) {
        for (E child : e.getChildren()) {
            child.addChild(e);
        }
    }

    public List<E> getSiblings(int id) { // Поиск братьев и сестёр...
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

    public boolean setWedding(int itemID1, int itemID2) {
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

    public boolean setDivorce(int itemID1, int itemID2) {
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

    public boolean remove(int itemID) {
        if (checkId(itemID)) {
            E e = getById(itemID);
            return itemList.remove(e);
        }
        return false;
    }

    private boolean checkId(int id) {
        return id < itemID && id >= 0;
    }

    public E getById(int id) {
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

    public int getSizeOfTree() {
        return itemList.size();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Всего объектов в семейном древе - ");
        sb.append(getSizeOfTree());
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

    public void sortById() {
        itemList.sort(new ItemComparatorById<>());
    }    

    public void sortByAge() {
        itemList.sort(new ItemComparatorByAge<>());
    }

    public void sortBySpouse() {
        itemList.sort(new ItemComparatorBySpouse<>());
    }
}
