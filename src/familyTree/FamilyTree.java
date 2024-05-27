package familyTree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<Human> {
    private long humansId;
    private final List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human) {
        if (human == null) {
            return;
        }
        if (!humanList.contains(human)) {
            humanList.add((Human) human);
            human.setId(humansId++);

            addToParents((E) human);
            addToChildren((E) human);

        }
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParents(human);
        }
    }

    public List<E> getSiblings(int id) {
        E human = (E) getById(id);
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

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public void setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = (E) getById(humanId1);
            E human2 = (E) getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }
        }
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = (E) getById(humanId1);
            E human2 = (E) getById(humanId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null) {
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            E human = (E) getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= humansId || id < 0) {
            return false;
        }
        for (Human human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return (Human) human;
            }
        }
        return null;
    }

//    @Override
//    public String toString() {
//        return "FamilyTree{" +
//                "humansId=" + humansId +
//                ", humanList=" + humanList +
//                '}';
//    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate());
    }

    public void sortByGender(){
        humanList.sort(new HumanComparatorByGender());
    }

    @Override
    public Iterator<Human> iterator(){
        FamilyTreeIterator familyTreeIterator = new FamilyTreeIterator(humanList);
        return familyTreeIterator;
    }
}