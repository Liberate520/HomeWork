package src.familyTree;

import src.human.Human;
import src.human.comparators.HumanComparatorByAge;
import src.human.comparators.HumanComparatorByDOB;
import src.human.comparators.HumanComparatorById;
import src.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeElement> implements Serializable, Iterable<E> {
    //  Поля:
    private List<E> humanList;

    //  Constructor:
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    //  Method:
    //  Setters:
    public boolean setWedding(int humanId1, int humanId2) {
        E human1 = getById(humanId1);
        E human2 = getById(humanId2);
        return setWedding(human1, human2);
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(int humanId1, int humanId2) {
        E human1 = getById(humanId1);
        E human2 = getById(humanId2);
        return setDivorce(human1, human2);
    }

    public boolean setDivorce(E human1, E human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (FamilyTreeElement parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (FamilyTreeElement child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public boolean remove(int humansId) {
        E human = getById(humansId);
        return humanList.remove(human);
    }

    //  Getters:
    public E getById(int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
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

    public int size() {
        return humanList.size();
    }

    //  Sorting:
    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

    public void sortById() {
        humanList.sort(new HumanComparatorById());
    }

    public void sortByDOB() {
        humanList.sort(new HumanComparatorByDOB());
    }

    //  Overrides:
    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator(humanList);
    }

}