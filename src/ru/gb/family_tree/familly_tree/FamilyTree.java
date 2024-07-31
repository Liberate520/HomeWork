package ru.gb.family_tree.familly_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByBirthDate;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {    // Список людей
    private long humansId;
    private List<Human> humanList;

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
        if (!(humanList.contains(human))) {
            humanList.add((human));
            human.setId(humansId++);

    //        addToParents(human);
    //        addToChildren(human);

        }
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human2.setSpouse(human1);
            human1.setSpouse(human2);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce (Human human1, Human human2){
        if(human1.getSpouse() == human2){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    public boolean checkId(long id) { return id < humansId && id >= 0; }

    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void sortByName() {
//        Collections.sort(humanList);
//        humanList.sort(null);
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate() {
//        Collections.sort(humanList, new HumanComparatorByBirthDate());
        humanList.sort(new HumanComparatorByBirthDate());
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
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator(){
        return new FamilyTreeIterator(humanList);  // Можно написать return humanList.iterator(), т.к. список людей уже - List
    }


//    public void sortByBirthDate(){                                        // изучаю
//        humanList.sort(new HumanComparatorByBirthDate());
//    }
//
//    public void sortByBirthDate(){                                        // изучаю
//        humanList.sort(new HumanComparatorByName());
//    }
}
