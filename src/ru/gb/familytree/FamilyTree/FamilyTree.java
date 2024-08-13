package ru.gb.familytree.FamilyTree;

import ru.gb.familytree.FamilyTree.Human.FamilyTreeItem;
import ru.gb.familytree.FamilyTree.Human.HumanIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem> implements Serializable, Iterable<T> {
    private List<T> relatives;

    public FamilyTree() {
        relatives = new ArrayList<>();
    }

    public void setRelative(T human) {
        this.relatives.add(human);
    }

    public List<T> getParentsForItem(T human) {
        List<T> parents = relatives.get(relatives.indexOf(human)).getParents();
        return parents;
    }

    public List<T> getChildrenForItem(T human) {
        return relatives.get(relatives.indexOf(human)).getChildren();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> itH = (Iterator<T>) new HumanIterator(relatives);
        return itH;
    }

    public void sortByName() {
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                if (o1.getName().equals(o2.getName())) {
                    return 0;
                }
                return o1.getName().compareTo(o2.getName());
            }
        };

        this.relatives.sort(comparator);
    }

    public void sortByBirthDate() {
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                if (o1.getBirthDate().equals(o2.getBirthDate())) {
                    return 0;
                }
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        };

        this.relatives.sort(comparator);
    }
}
