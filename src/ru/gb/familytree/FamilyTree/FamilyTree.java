package ru.gb.familytree.FamilyTree;

import ru.gb.familytree.FamilyTree.Human.Human;
import ru.gb.familytree.FamilyTree.Human.HumanIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>, {
    private List<Human> relatives;

    public FamilyTree() {
        relatives = new ArrayList<>();
    }

    public void setRelative(Human human) {
        this.relatives.add(human);
    }

    public List<Human> getParentsForHuman(Human human) {
        List<Human> parents = relatives.get(human).getParents();
        return parents;
    }

    public List<Human> getChildrenForHuman(Human human) {
        return relatives.get(relatives.indexOf(human)).getChildren();
    }

    @Override
    public Iterator<Human> iterator() {
        Iterator<Human> itH = new HumanIterator(relatives);
        return itH;
    }

    public void sortByName() {
        Comparator<Human> comparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
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
        Comparator<Human> comparator = new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
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
