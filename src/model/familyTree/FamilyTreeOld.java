package model.familyTree;

import model.human.Human;
import view.util.Helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeOld<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private final List<E> humanList;
    private long countHumans;

    public FamilyTreeOld(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTreeOld() {
        this(new ArrayList<>());
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }

        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(countHumans++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
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

    private boolean checkId(long id) {
        return id < countHumans && id >= 0;
    }

    public E getById(long id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);

        if (human == null) {
            return null;
        }

        List<E> res = new ArrayList<>();

        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(Helpers.formatDataString("Total humans in tree: ", String.valueOf(countHumans)));
        for (E human : humanList) {
            sb.append("\n===============\n");
            sb.append(human);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public void sortByName() {
        humanList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByDayOfBirth() {
        humanList.sort(new FamilyTreeComparatorByDayOfBirth<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }
}
