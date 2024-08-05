package ru.gb.family_tree.familly_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByBirthDate;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends ItemFamilyTree> implements Serializable, Iterable<T> {    // Список людей
    private long humansId;
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean add(T human) {
        if (human == null) {
            return false;
        }
        if (!(humanList.contains(human))) {
            humanList.add((human));
            long id = getMaxId();
            human.setId(humansId++);
            return true;
        }
        return false;
    }

    private long getMaxId() {
        long maxId = -1;
        for (T human : humanList) {
            if (human.getId() > maxId) {
                maxId = human.getId();
            }
        }
        return maxId;
    }

    public void setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human2.setSpouse(human1);
            human1.setSpouse(human2);
        }
    }

    public boolean setDivorce (Human human1,Human human2){
        if(human1.getSpouse() == human2){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            T human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    public boolean checkId(long id) { return id < humansId && id >= 0; }

    public T getById(long id) {
        for (T human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void sortByName() {
//        Collections.sort(humanList);
//        humanList.sort(null);
        humanList.sort(new HumanComparatorByName<>());
    }
    public void sortByBirthDate() {
//        Collections.sort(humanList, new HumanComparatorByBirthDate());
        humanList.sort(new HumanComparatorByBirthDate<>());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator(){
        return new FamilyTreeIterator<>(humanList);  // Можно написать return humanList.iterator(), т.к. список людей уже - List
    }

}
