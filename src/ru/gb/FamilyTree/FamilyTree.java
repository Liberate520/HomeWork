package ru.gb.FamilyTree;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeMyTop<T>>implements Serializable,Iterable<T> {

    private long humansId;
    private List<T> humanList;

    public FamilyTree() {
        this (new ArrayList<>());
    }


    public FamilyTree(List<T> humanList) {

        this.humanList = humanList;
    }

//    @Override
//    public Iterator<Human> iterator() {
//        return null;
//    }

    public boolean add(T human){
        if(human == null){
            return false ;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }


    private void addToParents(T human){
        for(T parent: human.getParents()){
            parent.addChildren(human);
        }
    }

    private void addToChildren(T human){
        for(T child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<T> getSiblings(long id){
        T human = getById(id);
        if(human == null){
            return null;
        }
        List<T> res = new ArrayList<>();
        for(T parent: human.getParents()){
            for (T child: human.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<T> getByName(String name){
        List<T> res = new ArrayList<>();
        for (T human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            T human1 = getById(humansId1);
            T human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.getSpouse(human2);
                human2.getSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDevorse(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            T human1 = getById(humansId1);
            T human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.getSpouse(human2);
                human2.getSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove (long humansId){
        if (checkId(humansId)){
            T human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public T getById(Long id){
        for (T human: humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(" в дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }


    public void sortByName() {
        humanList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByBirthDate() {
        humanList.sort(new FamilyTreeComparatorByBirthDate<>());
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }
}