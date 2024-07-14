package family_tree.family_tree;

import family_tree.human.Human;
import family_tree.human.HumanComparatorByBirthDate;
import family_tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class FamilyTree<T extends Item<T>> implements Serializable, Iterable<T> {

    private long humansId;
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean addHuman(T human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(T human) {
        for (T parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(T human) {
        for (T child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<T> getSiblings(int id) {
        T human = getById(id);
        if (human == null) {
            return null;
        }
        List<T> res = new ArrayList<>();
        for (T parent : human.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }


    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setFatherChild(T human1,T human2) {
        if (human2.getFather() == null) {
            for (T child : human1.getChildren()) {
                if(!child.equals(human2)){
                    human1.getChildren().add(human2);
                }
            }
            human2.setFather(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setMotherChild(T human1, T human2) {
        if (human2.getMother() == null) {
            for (T child : human1.getChildren()) {
                if(!child.equals(human2)){
                    human1.getChildren().add(human2);
                }
            }
            human2.setMother(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            T human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    public T getById(long id) {
        for (T human : humanList) {
            if (human.getId() == id) {
                return human;
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
        sb.append("В генеалогическом древе ");
        sb.append(humanList.size());
        sb.append(" членов семьи: \n");
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate<>());
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

}
