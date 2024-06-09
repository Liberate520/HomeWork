package com.familytree.model.family_tree;

import com.familytree.model.human.Human;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends TreeNode> implements Serializable, Iterable<T> {
    private long humanId;
    private List<Human> humanList;
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human) {
        humans.add(human);
    }



    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public void setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }
        }
    }

    private boolean checkId(long id) {
        return id < humanId && id >= 0;
    }

    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }


    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByBirthDate());
    }


    public Iterator<T> iterator() {
        return new FamilyTreeIterator(humanList);
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (humanList != null) {
            sb.append("В дереве ");
            sb.append(humanList.size());
            sb.append(" объектов: \n");
            for (Human human : humanList) {
                sb.append(human);
                sb.append("\n");
            }
        } else {
            sb.append("Дерево пустое или не инициализировано.");
        }
        return sb.toString();
    }

}



