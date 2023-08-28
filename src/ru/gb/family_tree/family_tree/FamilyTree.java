package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.family_tree.comparator.FamilyTreeComparatorByAge;
import ru.gb.family_tree.family_tree.comparator.FamilyTreeComparatorByBirthDate;
import ru.gb.family_tree.family_tree.comparator.FamilyTreeComparatorByName;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanlist;

    public FamilyTree(List<E> humanlist){
        this.humanlist = humanlist;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanlist.contains(human)){
            humanlist.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id){
        E human = getById(id);
        if (human == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent: human.getParents()){
            for (E child: parent.getChildren()){
                if (!child.equals(human) && !res.contains(child)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanlist){
            if (human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDevorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null) {
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDevorce(E human1, E human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
        } else {
            return false;
        }
        return false;
    }

    public boolean remove(long humansId){
        if (checkId(humansId)){
            E human = getById(humansId);
            return humanlist.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        if (id > humansId || id < 0){
            return false;
        }
        for (E human: humanlist){
            if (human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public E getById(long id){
        for (E human: humanlist){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanlist.size());
        sb.append(" объектов: \n");
        for (E human: humanlist){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanlist);
    }

    public void sortByName() {
        humanlist.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByAge() {
        humanlist.sort(new FamilyTreeComparatorByAge<>());
    }

    public void sortByBirthDate() {
        humanlist.sort(new FamilyTreeComparatorByBirthDate<>());
    }
}
